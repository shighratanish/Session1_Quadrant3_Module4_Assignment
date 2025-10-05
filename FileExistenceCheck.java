// FileExistenceCheck.java

import java.io.File;
import java.io.IOException;

public class FileExistenceCheck {
    public static void main(String[] args) {
        String fileName = "newfile.txt";
        File file = new File(fileName);

        if (file.exists()) {
            System.out.println(fileName + " already exists.");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println(fileName + " created successfully.");
                } else {
                    System.out.println("Failed to create " + fileName);
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }
}
