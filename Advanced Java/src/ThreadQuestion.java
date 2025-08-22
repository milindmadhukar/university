class Worker1 extends Thread {
  public void run() {
    System.out.println("Assembling the car chasis");
  }
}

class Worker2 extends Thread {
  public void run() {
    System.out.println("Painting the car");
  }
}

public class ThreadQuestion {
  public static void main(String[] args) {
    Worker1 w1 = new Worker1();
    Worker2 w2 = new Worker2();

    w1.start();
    try {
      w1.join();
      System.out.println("Chasis done.");
    } catch (InterruptedException e)  {
      System.out.println("No.");
    }
    w2.start();
    try {
      w2.join();
      System.out.println("Painting done");
    } catch (InterruptedException e)  {
      System.out.println("No.");
    }
  }
}
