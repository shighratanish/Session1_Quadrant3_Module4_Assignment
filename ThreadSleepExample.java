// ThreadSleepExample.java

class ThreadOne extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread 1");
            try {
                Thread.sleep(1000); // 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrupted: " + e.getMessage());
                break;
            }
        }
    }
}

class ThreadTwo extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread 2");
            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread 2 interrupted: " + e.getMessage());
                break;
            }
        }
    }
}

public class ThreadSleepExample {
    public static void main(String[] args) {
        Thread t1 = new ThreadOne();
        Thread t2 = new ThreadTwo();
        t1.start();
        t2.start();
    }
}
