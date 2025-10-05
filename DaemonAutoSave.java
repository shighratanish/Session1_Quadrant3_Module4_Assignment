// DaemonAutoSave.java

class AutoSaveThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Auto-Save in progress...");
            try {
                Thread.sleep(3000); // every 3 seconds
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class DaemonAutoSave {
    public static void main(String[] args) {
        AutoSaveThread autoSave = new AutoSaveThread();
        autoSave.setDaemon(true); // set as daemon thread
        autoSave.start();

        // Simulate main thread performing file processing
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread processing file " + i);
            try {
                Thread.sleep(2000); // 2 seconds per task
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted: " + e.getMessage());
            }
        }

        System.out.println("Main thread finished processing. Program ends, daemon stops.");
    }
}
