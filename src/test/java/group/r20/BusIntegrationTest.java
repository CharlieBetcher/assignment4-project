package group.r20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusIntegrationTest {

    BusRepository repo;

    @BeforeEach
    public void setup() {

        repo = new BusRepository();
        repo.clear();
    }

    // Integration Test 1
    @Test
    public void testInvalidBusRejected() {

        Bus invalidBus = new Bus(
                "12AB567",
                40,
                50.0,
                "Hybrid",
                40,
                5,
                "Heavy"
        );

        boolean result = repo.addBus(invalidBus);

        assertFalse(result);
        assertEquals(0, repo.countBuses());

    }

    // Integration Test 2
    @Test
    public void testBusUpdatePersisted() {

        Bus validBus = new Bus(

                "12345678",
                50,
                80.0,
                "Diesel",
                40,
                5,
                "Heavy"
        );

        repo.addBus(validBus);

        boolean updated = repo.updateBusCapacity("12345678", 45);
        assertTrue(updated);

        String storedRecord = repo.readAll().get(0);
        assertTrue(storedRecord.contains("45"));
    }
}
