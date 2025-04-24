import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int recordCount = 1;

        do {
            String firstName = safeInput.getNonZeroLenString(in, "Enter your first name:");
            String lastName = safeInput.getNonZeroLenString(in, "Enter your last name:");
            String userID = String.format("%06d", recordCount++);
            String yourEmail = safeInput.getNonZeroLenString(in, "Enter your email:");
            int birthYear = safeInput.getRangedInt(in, "Enter year of birth:", 1900, 2025);

            String record = String.format("%s,%s,%s,%s,%d", firstName, lastName, userID, yourEmail, birthYear);
            records.add(record);
        } while (safeInput.getYNConfirm(in, "Would you like to enter another record?"));

        String fileName = safeInput.getNonZeroLenString(in, "Enter the filename to save (add .csv):");

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

