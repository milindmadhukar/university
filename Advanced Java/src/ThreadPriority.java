class Test extends Thread {
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("Thread priority: " + Thread.currentThread().getPriority());
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        Test thrd1 = new Test();
        Test thrd2 = new Test();

        thrd1.setName("My Thread 1");
        thrd2.setName("My Thread 2");

        thrd1.setPriority(Thread.MIN_PRIORITY);
        thrd2.setPriority(Thread.MAX_PRIORITY);

        try {
            thrd1.setPriority(21);
        } catch (IllegalArgumentException e) {
            System.out.println("Thread priority must be between 1 and 10");
        }

        thrd1.start();
        thrd2.start();
    }
}
