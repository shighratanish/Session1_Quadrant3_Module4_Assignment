// ProducerConsumerWaitNotify.java

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public void produce() throws InterruptedException {
        int value = 1;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait(); // wait if buffer is full
                }
                buffer.add(value);
                System.out.println("Produced: " + value);
                value++;
                notify(); // notify consumer
            }
            Thread.sleep(500); // simulate production time
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait(); // wait if buffer is empty
                }
                int val = buffer.poll();
                System.out.println("Consumed: " + val);
                notify(); // notify producer
            }
            Thread.sleep(800); // simulate consumption time
        }
    }
}

class ProducerThread extends Thread {
    private ProducerConsumer pc;

    public ProducerThread(ProducerConsumer pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.produce();
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted.");
        }
    }
}

class ConsumerThread extends Thread {
    private ProducerConsumer pc;

    public ConsumerThread(ProducerConsumer pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.consume();
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
        }
    }
}

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producer = new ProducerThread(pc);
        Thread consumer = new ConsumerThread(pc);

        producer.start();
        consumer.start();
    }
}
