// JavaLangExample.java

public class JavaLangExample {
    public static void main(String[] args) {
        // Math.random(): generate random number between 0.0 and 1.0
        double randomNum = Math.random();
        System.out.println("Random number: " + randomNum);

        // Math.abs(): absolute value
        int negative = -25;
        System.out.println("Absolute value of " + negative + " is " + Math.abs(negative));

        // Math.pow(): exponentiation
        double base = 5;
        double exponent = 3;
        System.out.println(base + " raised to power " + exponent + " is " + Math.pow(base, exponent));
    }
}
