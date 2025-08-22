class Test extends Thread {
    private volatile boolean stop_flag = true;

    public void stopRunning() {
        stop_flag = false;
    }

    @Override
    public void run() {
        while (stop_flag) {
          System.out.println("Thread is running...");
        }
        System.out.println("Thread stopped!");
    }
    
}

public class StopThread {
    public static void main(String[] args) {
      Test stop_thread = new Test();
      stop_thread.start();

      try {
          Thread.sleep(1000); // Let the thread run for a while
      } catch (InterruptedException e) {
          System.out.println("Main thread interrupted");
          e.printStackTrace();
      }

      stop_thread.stopRunning(); // Stop the thread
    }
}
