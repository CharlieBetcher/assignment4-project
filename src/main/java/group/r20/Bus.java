package group.r20;

public class Bus {

    private String busID;
    private int capacity;
    private double fuelLevel;
    private String fuelType;
    private int driverAge;
    private int driverExperience;
    private String driverLicense;

    // Constructor for Unit Tests
    public Bus(String busID, int capacity, String fuelType, int driverAge, int driverExperience, String driverLicense) {

        this.busID = busID;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.driverAge = driverAge;
        this.driverExperience = driverExperience;
        this.driverLicense = driverLicense;

        // Default value for unit tests
        this.fuelLevel = 0.0;
    }


    // Constructor for Integration Tests


    public Bus(String busID, int capacity, double fuelLevel, String fuelType, int driverAge, int driverExperience, String driverLicense) {

        this.busID = busID;
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
        this.fuelType = fuelType;
        this.driverAge = driverAge;
        this.driverExperience = driverExperience;
        this.driverLicense = driverLicense;
    }

    // B1 - Bus ID Validation
    public boolean isValidBusID() {

        if (busID == null) {
            return false;
        }

        // Must be exactly 8 digits
        return busID.matches("\\d{8}");
    }

    // B2 - Capacity Update Restriction

    public boolean updateCapacity(int newCapacity) {
        // Allow same or lower capacity
        if (newCapacity <= capacity) {
            capacity = newCapacity;
            return true;
        }

        // Reject increases
        return false;
    }

    // B3 - Driver Age Restriction

    public boolean canDriveHighCapacity() {
        // Age 50+ cannot drive buses with capacity 50+
        if (capacity >= 50 && driverAge >= 50) {
            return false;
        }

        return true;
    }

    // B4 - Electric Bus Restriction
    public boolean canDriveElectricBus() {
        // Rule only applies to electric buses
        if (!fuelType.equalsIgnoreCase("Electricity")) {
            return true;
        }

        // Must have at least 5 years experience
        return driverExperience >= 5;
    }

    // B5 - Driver License Restriction
    public boolean canDriveByLicense() {
        // Rule only applies to electric buses
        if (!fuelType.equalsIgnoreCase("Electricity")) {
            return true;
        }

        // Only Heavy or PublicTransport licences allowed
        return driverLicense.equals("Heavy") || driverLicense.equals("PublicTransport");

    }


    // Getters
    public String getBusID() {
        return busID;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public String getFuelType() {
        return fuelType;
    }

    // TXT File Storage Format
    @Override
    public String toString() {

        return busID + "," +
                capacity + "," +
                fuelLevel + "," +
                fuelType;
    }
}