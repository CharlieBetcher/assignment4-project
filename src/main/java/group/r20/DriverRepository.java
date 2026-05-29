package group.r20;

import java.io.*;
import java.util.*;

public class DriverRepository {

    private static final String FILE_NAME = "drivers.txt";

    // Add driver
    public void addDriver(Driver driver) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            
            writer.write(driverToLine(driver)
            );
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Count driver
    public int countDrivers() {
        return readAll().size();
    }

    // Get all drivers
    public List<String> readAll() {

        List<String> drivers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    drivers.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return drivers;
    }

    // Serialisation
    private String driverToLine(Driver d) {
        return d.toString();
    }

    // Clear file (for testing)
    public void clear() {
        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
