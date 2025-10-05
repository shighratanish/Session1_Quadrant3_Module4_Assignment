// ThreadNamingAndPriority.java

class WorkerThread extends Thread {
    public WorkerThread(String name, int priority) {
        super(name);
        setPriority(priority); // Set thread priority
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " is working, iteration " + i);
            try {
                Thread.sleep(500); // small delay to see the output clearly
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted: " + e.getMessage());
            }
        }
    }
}

public class ThreadNamingAndPriority {
    public static void main(String[] args) {
        WorkerThread worker1 = new WorkerThread("Worker-1", Thread.MIN_PRIORITY);
        WorkerThread worker2 = new WorkerThread("Worker-2", Thread.NORM_PRIORITY);
        WorkerThread worker3 = new WorkerThread("Worker-3", Thread.MAX_PRIORITY);

        worker1.start();
        worker2.start();
        worker3.start();
    }
}
