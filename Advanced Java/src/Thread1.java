class Test extends Thread {
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + "\n" + "Thread is daemon: " + Thread.currentThread().isDaemon());
    }
}

public class Thread1 extends Thread {
    public static void main(String[] args) {
        System.out.println("\nMain thread is daemon: " + Thread.currentThread().isDaemon());
        Test thrd1 = new Test();
        Test thrd2 = new Test();
        thrd1.setDaemon(true);

        thrd1.start();
        thrd2.start();
    }
}

