// ReadFileByteStream.java

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileByteStream {
    public static void main(String[] args) {
        String fileName = "input.txt"; // file to read

        try (FileInputStream fis = new FileInputStream(fileName)) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // convert byte to char
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
