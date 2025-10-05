// WriteFileCharStream.java

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileCharStream {
    public static void main(String[] args) {
        String data = "This is an example using FileWriter.";
        String fileName = "example.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(data);
            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
