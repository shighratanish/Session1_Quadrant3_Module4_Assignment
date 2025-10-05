// RunnableReverseString.java

class ReverseStringRunnable implements Runnable {
    private String str;

    public ReverseStringRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.println(str.charAt(i));
            try {
                Thread.sleep(300); // small delay for clarity
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class RunnableReverseString {
    public static void main(String[] args) {
        String text = "MULTITHREADING";
        Thread thread = new Thread(new ReverseStringRunnable(text));
        thread.start();
    }
}
