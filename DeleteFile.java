// DeleteFile.java

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        String fileName = "copy.txt";
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + " deleted successfully.");
            } else {
                System.out.println("Failed to delete " + fileName);
            }
        } else {
            System.out.println(fileName + " does not exist.");
        }
    }
}
