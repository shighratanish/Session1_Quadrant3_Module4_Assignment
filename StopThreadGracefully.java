// StopThreadGracefully.java

class DownloadThread extends Thread {
    private volatile boolean running = true; // stop flag

    public void stopDownload() {
        running = false; // set flag to false to stop the thread
    }

    @Override
    public void run() {
        int chunk = 1;
        while (running) {
            System.out.println("Downloading chunk " + chunk);
            chunk++;
            try {
                Thread.sleep(500); // simulate download time per chunk
            } catch (InterruptedException e) {
                System.out.println("Download interrupted.");
            }
        }
        System.out.println("Download stopped gracefully.");
    }
}

public class StopThreadGracefully {
    public static void main(String[] args) {
        DownloadThread download = new DownloadThread();
        download.start();

        try {
            Thread.sleep(3000); // let the download run for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        download.stopDownload(); // stop the download gracefully
    }
}
