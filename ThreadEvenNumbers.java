// ThreadEvenNumbers.java

class EvenNumbersThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(500); // 500ms delay
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class ThreadEvenNumbers {
    public static void main(String[] args) {
        EvenNumbersThread thread = new EvenNumbersThread();
        thread.start();
    }
}
