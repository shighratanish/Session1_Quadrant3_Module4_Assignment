// BufferedIOExample.java

import java.io.*;

public class BufferedIOExample {
    public static void main(String[] args) {
        String inputFile = "example.txt";
        String outputFile = "buffered_output.txt";

        // Reading with BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // print to console
                bw.write(line);           // write to output file
                bw.newLine();
            }
            System.out.println("Buffered reading and writing completed.");

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
