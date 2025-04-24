import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser filePicker = new JFileChooser(new File("src"));
        int result = filePicker.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filePicker.getSelectedFile();
            int totallineCount = 0;
            int totalwordCount = 0;
            int totalcharCount = 0;

            try (Scanner fileScanner = new Scanner(selectedFile)) {
                System.out.println("Contents of the file:\n");
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                    totallineCount++;
                    String[] words = line.trim().split("\\s+");
                    totalwordCount += (line.trim().isEmpty()) ? 0 : words.length;
                    totalcharCount += line.length();
                }

                System.out.println("\n--- Summary Report ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number count of lines: " + totallineCount);
                System.out.println("Number count of words: " + totalwordCount);
                System.out.println("Number count of characters: " + totalcharCount);

            } catch (FileNotFoundException e) {
                System.out.println("The file has not been found: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error has occurred: " + e.getMessage());
            }
        } else {
            System.out.println("No file has been selected.");
        }
    }
}

