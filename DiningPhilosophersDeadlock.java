// DiningPhilosophersDeadlock.java

class Chopstick {
    private final String name;

    public Chopstick(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Philosopher extends Thread {
    private Chopstick left, right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (left) { // pick up left chopstick
                    System.out.println(getName() + " picked up " + left.getName());
                    Thread.sleep(100); // small delay
                    synchronized (right) { // pick up right chopstick
                        System.out.println(getName() + " picked up " + right.getName());
                        eat();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }

    private void think() throws InterruptedException {
        System.out.println(getName() + " is thinking...");
        Thread.sleep(200);
    }

    private void eat() throws InterruptedException {
        System.out.println(getName() + " is eating...");
        Thread.sleep(300);
    }
}

public class DiningPhilosophersDeadlock {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("Chopstick-1");
        Chopstick c2 = new Chopstick("Chopstick-2");

        Philosopher p1 = new Philosopher("Philosopher-1", c1, c2);
        Philosopher p2 = new Philosopher("Philosopher-2", c2, c1);

        p1.start();
        p2.start();
    }
}
