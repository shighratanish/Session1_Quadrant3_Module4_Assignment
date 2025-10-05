// SynchronizedInventory.java

class Inventory {
    private int stock = 10;

    public void decreaseStock(String threadName) {
        // synchronized block ensures only one thread can decrease stock at a time
        synchronized (this) {
            if (stock > 0) {
                System.out.println(threadName + " purchased 1 item. Stock left: " + (stock - 1));
                stock--;
            } else {
                System.out.println(threadName + " tried to purchase, but stock is empty.");
            }
        }
    }
}

class InventoryThread extends Thread {
    private Inventory inventory;

    public InventoryThread(Inventory inventory, String name) {
        super(name);
        this.inventory = inventory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // each thread tries to purchase 3 items
            inventory.decreaseStock(getName());
            try {
                Thread.sleep(300); // delay for demonstration
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}

public class SynchronizedInventory {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Thread t1 = new InventoryThread(inventory, "Thread-1");
        Thread t2 = new InventoryThread(inventory, "Thread-2");
        Thread t3 = new InventoryThread(inventory, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
