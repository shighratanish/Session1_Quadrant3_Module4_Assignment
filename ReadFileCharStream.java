// ReadFileCharStream.java

import java.io.FileReader;
import java.io.IOException;

public class ReadFileCharStream {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (FileReader fr = new FileReader(fileName)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
