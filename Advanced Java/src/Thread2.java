class Test extends Thread {
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + "\n" + "Thread is daemon: " + Thread.currentThread().isDaemon());
    }
}


public class Thread2 {
    public static void main(String[] args) {
        Test thrd1 = new Test();
        Test thrd2 = new Test();

        thrd1.setName("My Thread 1");
        thrd2.setName("My Thread 2");

        thrd1.start();

        try {
            thrd1.setDaemon(true);
        } catch (IllegalThreadStateException e) {
            System.out.println("Thread cannot be set as daemon after starting");
        }

        thrd2.start();
    }
}
