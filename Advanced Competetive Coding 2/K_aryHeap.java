import java.util.*;

public class K_aryHeap {
    private ArrayList<Integer> heap;
    private int k;

    public K_aryHeap(int k) {
        this.heap = new ArrayList<>();
        this.k = k;
    }

    // Get parent index
    private int parent(int i) {
        return (i - 1) / k;
    }

    // Get jth child index
    private int child(int i, int j) {
        return k * i + j + 1;
    }

    // Heapify up operation
    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            // Swap with parent
            int temp = heap.get(i);
            heap.set(i, heap.get(parent(i)));
            heap.set(parent(i), temp);
            i = parent(i);
        }
    }

    // Heapify down operation
    private void heapifyDown(int i) {
        while (true) {
            int maxIndex = i;
            int start = k * i + 1;
            int end = Math.min(start + k, heap.size());
            
            for (int j = start; j < end; j++) {
                if (heap.get(j) > heap.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            
            if (maxIndex == i) {
                break;
            }
            
            int temp = heap.get(i);
            heap.set(i, heap.get(maxIndex));
            heap.set(maxIndex, temp);
            i = maxIndex;
        }
    }

    // Insert a new element
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Extract maximum element
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int result = heap.get(0);
        
        // Replace root with last element and remove last
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return result;
    }

    // Build heap from array
    public void buildHeap(int[] array) {
        heap.clear();
        for (int value : array) {
            heap.add(value);
        }

        // Heapify down from last non-leaf node
        for (int i = (heap.size() - 2) / k; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Print the heap
    public void printHeap() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input
        int n = scanner.nextInt();
        int[] arr = new int[n - 1];  // Changed to n-1 to match expected output
        for (int i = 0; i < n - 1; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Read value to insert
        int insertValue = scanner.nextInt();
        
        // Read k value
        int k = scanner.nextInt();
        
        // Create k-ary heap
        K_aryHeap kHeap = new K_aryHeap(k);
        
        // Build heap
        System.out.println("Built Heap : ");
        kHeap.buildHeap(arr);
        kHeap.printHeap();
        
        // Insert new value
        System.out.println("Heap after insertion of " + insertValue + ": ");
        kHeap.insert(insertValue);
        kHeap.printHeap();
        
        // Extract max
        int max = kHeap.extractMax();
        System.out.println("Extracted max is " + max);
        System.out.println("Heap after extract max: ");
        kHeap.printHeap();
        
        scanner.close();
    }
}

