// RandomAccessFileExample.java

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        String fileName = "random.txt";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Write data at the beginning
            raf.writeUTF("Hello, Java!");

            // Move file pointer to the start
            raf.seek(0);
            System.out.println("Reading from file: " + raf.readUTF());

            // Move file pointer to overwrite part of the data
            raf.seek(7); // move to position 7
            raf.writeUTF("World");

            // Move pointer to start and read updated content
            raf.seek(0);
            System.out.println("After overwrite: " + raf.readUTF());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
