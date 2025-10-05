// DeadlockTryLock.java

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class DeadlockTask implements Runnable {
    private Lock lock1;
    private Lock lock2;
    private String name;

    public DeadlockTask(Lock lock1, Lock lock2, String name) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(name + " acquired lock1");
                        Thread.sleep(500);
                        if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println(name + " acquired lock2");
                                System.out.println(name + " performing work...");
                                break;
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println(name + " could not acquire lock2, retrying...");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println(name + " could not acquire lock1, retrying...");
                }
                Thread.sleep(500); // wait before retrying
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DeadlockTryLock {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(new DeadlockTask(lock1, lock2, "Thread-1"));
        Thread t2 = new Thread(new DeadlockTask(lock2, lock1, "Thread-2"));

        t1.start();
        t2.start();
    }
}
