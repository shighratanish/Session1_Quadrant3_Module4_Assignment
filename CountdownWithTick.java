// CountdownWithTick.java

class CountdownThread extends Thread {
    @Override
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println("Countdown: " + i);
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.out.println("Countdown thread interrupted: " + e.getMessage());
            }
        }
    }
}

class TickThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) { // 10 seconds total, tick every 0.5s
            System.out.println("Tick...");
            try {
                Thread.sleep(500); // 0.5 second delay
            } catch (InterruptedException e) {
                System.out.println("Tick thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class CountdownWithTick {
    public static void main(String[] args) {
        Thread countdown = new CountdownThread();
        Thread tick = new TickThread();
        countdown.start();
        tick.start();
    }
}
