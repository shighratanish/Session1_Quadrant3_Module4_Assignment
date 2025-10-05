// ListFilesInDirectory.java

import java.io.File;
import java.util.Scanner;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = sc.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            if (files != null && files.length > 0) {
                System.out.println("Files in directory:");
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("Directory is empty.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        sc.close();
    }
}
