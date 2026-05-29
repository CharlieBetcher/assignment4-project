package group.r20;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DriverIntegrationTest {

    DriverRepository repo;
    @BeforeEach
    public void setup() {
        repo = new DriverRepository();
        repo.clear();
    }

    // Integration Test 1
    @Test
    public void testValidDriverStoredInFile() {

        Driver driver = new Driver(
                "23@@56!!AB",
                "John Smith",
                5,
                "Heavy",
                "15|Queen St|Sydney|NSW|Australia",
                "10-05-1990"
        );

        repo.addDriver(driver);

        assertEquals(1, repo.countDrivers());
        assertTrue(repo.readAll().get(0).contains("John Smith"));

    }

    // Integration Test 2
    @Test
    public void testDriverCountIncreasesAfterAdd() {
        Driver driver1 = new Driver(
                "23@@56!!AB",
                "John Smith",
                5,
                "Heavy",
                "15|Queen St|Sydney|NSW|Australia",
                "10-05-1990"
        );

        repo.addDriver(driver1);
        assertEquals(1, repo.countDrivers());

        Driver driver2 = new Driver(
                "99##88!!ZZ",
                "Emma White",
                8,
                "Medium",
                "9|Lake Rd|Adelaide|SA|Australia",
                "15-08-1992"
        );

        repo.addDriver(driver2);
        assertEquals(2, repo.countDrivers());
    }
}
