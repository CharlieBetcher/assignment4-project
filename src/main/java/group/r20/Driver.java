package group.r20;

public class Driver {

    private String driverID;
    private String name;
    private int experienceYears;
    private String licenseType;
    private String address;
    private String birthdate;

    // Constructor
    public Driver(String driverID, String name, int experienceYears, String licenseType, String address, String birthdate) {

        this.driverID = driverID;
        this.name = name;
        this.experienceYears = experienceYears;
        this.licenseType = licenseType;
        this.address = address;
        this.birthdate = birthdate;

    }

    // D1 - Validate Driver ID
    public boolean isValidDriverID() {

        if (driverID == null) return false;
        if (driverID.length() != 10) {

            return false;
        }

        int specialCount = 0;

        for (char c : driverID.toCharArray()) {

            if (!Character.isLetterOrDigit(c)) {
                specialCount++;
            }
        }

        return specialCount >= 2;
    }

    // D2 - Validate Address
    public boolean isValidAddress() {

        if (address == null || address.isEmpty()) {
            return false;
        }

        String[] parts = address.split("\\|");
        return parts.length == 5;
    }

    // D3 - Validate Birthdate
    public boolean isValidBirthdate() {

        if (birthdate == null) return false;

        return birthdate.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    // D4 - License Update Rule
    public boolean canUpdateLicense(String newLicense) {

        if (experienceYears > 10) {
            return false;

        }

        return true;
    }

    // D5 - Immutable Fields
    public boolean updateDriver(String newDriverID, String newName, int newExperienceYears, String newLicenseType) {

        if (!this.driverID.equals(newDriverID)) return false;
        if (!this.name.equals(newName)) return false;

        this.experienceYears = newExperienceYears;
        this.licenseType = newLicenseType;

        return true;
    }

    @Override
    public String toString() {
        return driverID + "," + name + "," + experienceYears + "," + licenseType + "," + address + "," + birthdate;
    }
}