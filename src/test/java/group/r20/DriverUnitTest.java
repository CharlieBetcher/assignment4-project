package group.r20;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverUnitTest {
    // D1 - DRIVER ID RULES

@Test
public void testValidDriverID() {
        Driver driver = new Driver(

                "23@@56!!AB",
                "John Smith",
                5,
                "Heavy",
                "12|King St|Melbourne|VIC|Australia",
                "10-05-1990"
        );

        assertTrue(driver.isValidDriverID());

}

@Test
public void testDriverIDWrongLength() {

        Driver driver = new Driver(
                "23@@AB",
                "John Smith",
                5,
                "Heavy",
                "12|King St|Melbourne|VIC|Australia",
                "10-05-1990"
        );

        assertFalse(driver.isValidDriverID());

}

@Test
public void testDriverIDMissingSpecialCharacters() {
        Driver driver = new Driver(

                "23456789AB",
                "John Smith",
                5,
                "Heavy",
                "12|King St|Melbourne|VIC|Australia",
                "10-05-1990"
        );

        assertFalse(driver.isValidDriverID());
}

    // D2 - ADDRESS
@Test
public void testValidAddressFormat() {

        Driver driver = new Driver(

                "23@@56!!AB",
                "Sarah Lee",
                7,
                "PublicTransport",
                "15|Queen St|Sydney|NSW|Australia",
                "12-06-1988"
        );

        assertTrue(driver.isValidAddress());

}
@Test
public void testInvalidAddressMissingFields() {

        Driver driver = new Driver(

                "23@@56!!AB",
                "Sarah Lee",
                7,
                "PublicTransport",
                "15|Queen St|Sydney",
                "12-06-1988"
        );

        assertFalse(driver.isValidAddress());

}

@Test
public void testEmptyAddress() {

        Driver driver = new Driver(
                "23@@56!!AB",
                "Sarah Lee",
                7,
                "PublicTransport",
                "",
                "12-06-1988"
        );

        assertFalse(driver.isValidAddress());
}

    // D3 - BIRTHDATE
@Test
public void testValidBirthdate() {
        Driver driver = new Driver(

                "23@@56!!AB",
                "Michael Tan",
                10,
                "Heavy",
                "10|George St|Brisbane|QLD|Australia",
                "25-12-1985"
        );

        assertTrue(driver.isValidBirthdate());

}

@Test
public void testInvalidBirthdateFormat() {

        Driver driver = new Driver(
                "23@@56!!AB",
                "Michael Tan",
                10,
                "Heavy",
                "10|George St|Brisbane|QLD|Australia",
                "1985-12-25"
        );

        assertFalse(driver.isValidBirthdate());

}

@Test

public void testBirthdateWithLetters() {
        Driver driver = new Driver(

                "23@@56!!AB",
                "Michael Tan",
                10,
                "Heavy",
                "10|George St|Brisbane|QLD|Australia",
                "AA-BB-CCCC"
        );

        assertFalse(driver.isValidBirthdate());

}

    // D4 - LICENSE RULES
@Test
public void testLicenseCannotChangeAfterTenYears() {
        Driver driver = new Driver(
                "23@@56!!AB",
                "David Brown",
                15,
                "Heavy",
                "1|Main St|Perth|WA|Australia",
                "01-01-1980"
        );

        assertFalse(driver.canUpdateLicense("PublicTransport"));

}

@Test

public void testLicenseCanChangeUnderTenYears() {
        Driver driver = new Driver(
                "23@@56!!AB",
                "David Brown",
                5,
                "Heavy",
                "1|Main St|Perth|WA|Australia",
                "01-01-1980"
        );

        assertTrue(driver.canUpdateLicense("PublicTransport"));
}

@Test

public void testLicenseChangeExactlyTenYears() {
        Driver driver = new Driver(
                "23@@56!!AB",
                "David Brown",
                10,
                "Heavy",
                "1|Main St|Perth|WA|Australia",
                "01-01-1980"
        );

        assertTrue(driver.canUpdateLicense("PublicTransport"));
}

    // D5 - IMMUTABLE FIELDS
@Test
public void testDriverIDCannotBeModified() {
        Driver driver = new Driver(
                "23@@56!!AB",
                "Emma White",
                8,
                "Medium",
                "9|Lake Rd|Adelaide|SA|Australia",
                "15-08-1992"
        );

        assertFalse(driver.updateDriver(
                "99##88!!ZZ",
                "Emma White",
                8,
                "Medium"

        ));

}

@Test
public void testNameCannotBeModified() {
        Driver driver = new Driver(
                "23@@56!!AB",
                "Emma White",
                8,
                "Medium",
                "9|Lake Rd|Adelaide|SA|Australia",
                "15-08-1992"
        );

        assertFalse(driver.updateDriver(
                "23@@56!!AB",
                "New Name",
                8,
                "Medium"

        ));

}

@Test

public void testValidUpdateWithoutChangingImmutableFields() {
        Driver driver = new Driver(
                "23@@56!!AB",
                "Emma White",
                8,
                "Medium",
                "9|Lake Rd|Adelaide|SA|Australia",
                "15-08-1992"

        );

        assertTrue(driver.updateDriver(
                "23@@56!!AB",
                "Emma White",
                9,
                "Heavy"
        ));

}
}