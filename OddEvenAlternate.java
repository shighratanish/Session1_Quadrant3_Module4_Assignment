// OddEvenAlternate.java

class OddEven {
    private int counter = 1;
    private final int max = 20;

    public synchronized void printOdd() throws InterruptedException {
        while (counter <= max) {
            if (counter % 2 == 0) {
                wait();
            } else {
                System.out.println("Odd: " + counter);
                counter++;
                notify();
            }
        }
    }

    public synchronized void printEven() throws InterruptedException {
        while (counter <= max) {
            if (counter % 2 != 0) {
                wait();
            } else {
                System.out.println("Even: " + counter);
                counter++;
                notify();
            }
        }
    }
}

class OddThread extends Thread {
    private OddEven oddEven;

    public OddThread(OddEven oddEven) {
        this.oddEven = oddEven;
    }

    @Override
    public void run() {
        try {
            oddEven.printOdd();
        } catch (InterruptedException e) {
            System.out.println("Odd thread interrupted.");
        }
    }
}

class EvenThread extends Thread {
    private OddEven oddEven;

    public EvenThread(OddEven oddEven) {
        this.oddEven = oddEven;
    }

    @Override
    public void run() {
        try {
            oddEven.printEven();
        } catch (InterruptedException e) {
            System.out.println("Even thread interrupted.");
        }
    }
}

public class OddEvenAlternate {
    public static void main(String[] args) {
        OddEven oddEven = new OddEven();

        Thread oddThread = new OddThread(oddEven);
        Thread evenThread = new EvenThread(oddEven);

        oddThread.start();
        evenThread.start();
    }
}
