package group.r20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusUnitTest {

    // B1 - BusID Rules
@Test
public void testValidBusID() {

        Bus bus = new Bus("12345678", 50, 0, "Diesel", 40, 6, "Heavy");
        assertTrue(bus.isValidBusID());
    }

@Test
public void testInvalidBusIDWrongLength() {
        Bus bus = new Bus("1234567", 50, 0, "Diesel", 40, 6, "Heavy");
        assertFalse(bus.isValidBusID());
    }

@Test
public void testInvalidBusIDWithLetters() {
        Bus bus = new Bus("12AB5678", 50, 0, "Diesel", 40, 6, "Heavy");
        assertFalse(bus.isValidBusID());
    }

    // B2 - Capacity Update
@Test
public void testValidCapacityDecrease() {
        Bus bus = new Bus("12345678", 60, 0, "Diesel", 40, 6, "Heavy");
        assertTrue(bus.updateCapacity(50));
    }

@Test
public void testInvalidCapacityIncrease() {
        Bus bus = new Bus("12345678", 50, 0, "Diesel", 40, 6, "Heavy");
        assertFalse(bus.updateCapacity(60));
    }

    @Test
    public void testNoChangeCapacity() {
        Bus bus = new Bus("12345678", 50, 0, "Diesel", 40, 6, "Heavy");
        assertTrue(bus.updateCapacity(50));
    }

    // B3 - Age Restriction
@Test
public void testUnderAgeLimitAllowed() {
        Bus bus = new Bus("12345678", 60, 0, "Diesel", 45, 6, "Heavy");
        assertTrue(bus.canDriveHighCapacity());
    }

@Test

public void testAtAgeLimit() {
        Bus bus = new Bus("12345678", 50, 0, "Diesel", 50, 6, "Heavy");
        assertFalse(bus.canDriveHighCapacity());
    }

@Test
public void testOverAgeLimit() {
        Bus bus = new Bus("12345678", 60, 0, "Diesel", 55, 6, "Heavy");
        assertFalse(bus.canDriveHighCapacity());
    }

    // B4 - Electric Bus Restriction
@Test
public void testElectricBusEnoughExperience() {
        Bus bus = new Bus("12345678", 50, 0, "Electricity", 40, 6, "Heavy");
        assertTrue(bus.canDriveElectricBus());
    }

@Test
public void testElectricBusInsufficientExperience() {
        Bus bus = new Bus("12345678", 50, 0, "Electricity", 40, 3, "Heavy");
        assertFalse(bus.canDriveElectricBus());
    }

@Test
public void testElectricBusEdgeCase() {
        Bus bus = new Bus("12345678", 50, 0, "Electricity", 40, 5, "Heavy");
        assertTrue(bus.canDriveElectricBus());
    }

    // B5 - License Restriction
@Test
public void testHeavyLicenseAllowedElectric() {
        Bus bus = new Bus("12345678", 50, 0, "Electricity", 40, 6, "Heavy");
        assertTrue(bus.canDriveByLicense());
    }

@Test
public void testPublicTransportLicenseAllowed() {
        Bus bus = new Bus("12345678", 50, 0, "Electricity", 40, 6, "PublicTransport");
        assertTrue(bus.canDriveByLicense());
    }

@Test
public void testStandardLicenseRejected() {
        Bus bus = new Bus("12345678", 50, 0, "Electricity", 40, 6, "Standard");
        assertFalse(bus.canDriveByLicense());
    }

}