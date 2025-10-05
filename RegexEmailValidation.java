// RegexEmailValidation.java

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class RegexEmailValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        // Regular expression for simple email validation
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println(email + " is a valid email address.");
        } else {
            System.out.println(email + " is NOT a valid email address.");
        }

        sc.close();
    }
}
