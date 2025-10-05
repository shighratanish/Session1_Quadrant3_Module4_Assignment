// WriteFileByteStream.java

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileByteStream {
    public static void main(String[] args) {
        String data = "Java I/O Streams Example";
        String fileName = "output.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(data.getBytes()); // convert string to bytes and write
            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
