// CopyFileByteStream.java

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByteStream {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destFile = "copy.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
