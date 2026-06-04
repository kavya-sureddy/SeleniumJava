package FileInputOutputReadWrite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class Filereadwritetext {

	public static void main(String[] args) {
    
		// Using a relative path, just like the Excel example
        String fileName = "kavyatest.txt";
        Path path = Paths.get(fileName);

//        // 1. WRITING DATA (Creates the file or overwrites it if it exists)
//        try {
//            // Prepare lines of text to write
//            List<String> linesToWrite = List.of(
//                "Username: Kavya",
//                "Password: Kavya123",
//                "Role: QA Enginner"
//            );
//
//            // Write all lines at once
//            Files.write(path, linesToWrite);
//            System.out.println("Text file written successfully at: " + path.toAbsolutePath());
//
//            // Optional: How to APPEND data to an existing file instead of overwriting
//            Files.writeString(path, "\nLast Login: " + java.time.LocalDate.now(), StandardOpenOption.APPEND);
//
//        } catch (IOException e) {
//            System.err.println("Error writing to file: " + e.getMessage());
//        }

        System.out.println("-------------------------------------------");

        // 2. READING DATA
        try {
            // Check if the file actually exists before reading
            if (Files.exists(path)) {
                
                // Read all lines from the file into a List
                List<String> allLines = Files.readAllLines(path);
                
                System.out.println("Reading content from " + fileName + ":\n");
                for (String line : allLines) {
                    System.out.println(line);
                }
                
            } else {
                System.out.println("File not found!");
            }

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

	