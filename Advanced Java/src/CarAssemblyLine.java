class Worker1 extends Thread {
    private boolean chassisAssembled = false;
    private final Object lock = new Object();
    
    public void run() {
        try {
            System.out.println("Worker1: Starting chassis assembly...");
            
            // Simulate assembly time (3 seconds)
            Thread.sleep(3000);
            
            synchronized(lock) {
                chassisAssembled = true;
                System.out.println("Worker1: Chassis assembly completed!");
                
                // Notify waiting threads that assembly is done
                lock.notifyAll();
            }
            
        } catch (InterruptedException e) {
            System.out.println("Worker1: Assembly interrupted!");
            Thread.currentThread().interrupt();
        }
    }
    
    // Method for Worker2 to check if chassis is ready
    public void waitForAssembly() throws InterruptedException {
        synchronized(lock) {
            while (!chassisAssembled) {
                System.out.println("Worker2: Waiting for chassis assembly to complete...");
                lock.wait(); // Wait until chassis is assembled
            }
        }
    }
}

// Worker2 class - Paints the chassis after assembly
class Worker2 extends Thread {
    private Worker1 worker1;
    
    public Worker2(Worker1 worker1) {
        this.worker1 = worker1;
    }
    
    public void run() {
        try {
            System.out.println("Worker2: Ready to paint, waiting for chassis...");
            
            // Wait for Worker1 to complete assembly
            worker1.waitForAssembly();
            
            System.out.println("Worker2: Starting to paint the chassis...");
            
            // Simulate painting time (2 seconds)
            Thread.sleep(2000);
            
            System.out.println("Worker2: Painting completed! Car is ready!");
            
        } catch (InterruptedException e) {
            System.out.println("Worker2: Painting interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}

// Main class to simulate the assembly line
public class CarAssemblyLine {
    public static void main(String[] args) {
        System.out.println("=== Car Assembly Line Simulation Started ===");
        System.out.println("Two workers will work in parallel with proper synchronization\n");
        
        // Create worker instances
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2(worker1);
        
        // Record start time
        long startTime = System.currentTimeMillis();
        
        // Start both threads
        worker1.start();
        worker2.start();
        
        try {
            // Wait for both workers to complete
            worker1.join();
            worker2.join();
            
            // Calculate total time
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            
            System.out.println("\n=== Assembly Line Process Completed ===");
            System.out.println("Total time taken: " + totalTime + " milliseconds");
            System.out.println("Car manufacturing completed successfully!");
            
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
            Thread.currentThread().interrupt();
        }
    }
}
