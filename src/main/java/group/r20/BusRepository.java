package group.r20;

import java.io.*;

import java.util.*;

public class BusRepository {

    private static final String FILE_NAME = "bus.txt";

    // Add Bus
    public boolean addBus(Bus bus) {

        // Reject invalid Bus IDs
        if (!bus.isValidBusID()) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(bus.toString());
            writer.newLine();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Retrieve All
    public List<String> readAll() {
        List<String> buses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    buses.add(line);
                }

            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return buses;
    }

    // Count
    public int countBuses() {

        return readAll().size();

    }

    // Update Bus Capacity
    public boolean updateBusCapacity(String busID, int newCapacity) {

        List<String> buses = readAll();
        List<String> updated = new ArrayList<>();

        boolean found = false;

        for (String line : buses) {

            String[] parts = line.split(",");

            if (parts[0].equals(busID)) {
                int oldCapacity = Integer.parseInt(parts[1]);

                if (newCapacity > oldCapacity) {
                    return false;
                }

                parts[1] = String.valueOf(newCapacity);

                updated.add(String.join(",", parts));

                found = true;

            } else {
                updated.add(line);
            }
        }

        if (!found) {
            return false;
        }

        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {

            for (String line : updated) {
                writer.println(line);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return true;
    }

    // Clear File

    public void clear() {

        try (PrintWriter writer = new PrintWriter(FILE_NAME)) {
            writer.print("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
