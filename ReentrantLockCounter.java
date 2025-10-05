// ReentrantLockCounter.java

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    // Increment with lock
    public void incrementWithLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    // Increment without lock
    public void incrementWithoutLock() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;
    private boolean useLock;

    public CounterThread(Counter counter, boolean useLock) {
        this.counter = counter;
        this.useLock = useLock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (useLock) {
                counter.incrementWithLock();
            } else {
                counter.incrementWithoutLock();
            }
        }
    }
}

public class ReentrantLockCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // With lock
        Thread t1 = new CounterThread(counter, true);
        Thread t2 = new CounterThread(counter, true);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter with lock: " + counter.getCount());

        // Reset counter for no-lock scenario
        counter = new Counter();

        Thread t3 = new CounterThread(counter, false);
        Thread t4 = new CounterThread(counter, false);

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("Counter without lock: " + counter.getCount());
    }
}
