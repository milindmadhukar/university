# 1) Fair Reader-Writer Lock Problem

### Consider a reader-writer lock as we discussed in class — a writer requires exclusive access to the lock, while readers may concurrently hold the lock with other readers. How would you implement a fair version of this lock (i.e., lock requests are granted in the order received)? Please present your pseudo-code and explain your rationale. 

### Initial Setup:

AccessGuard = Semaphore(1)      # Binary semaphore to protect shared structures
ResourceAvailable = Semaphore(0) # Semaphore to manage resource accessibility
RequestQueue = new Queue()      # FIFO queue for managing access requests
ActiveReaders = 0               # Counter for currently active readers

### Explanation of Initialization:

We set up the necessary synchronization primitives and data structures:

- AccessGuard: A binary semaphore initialized to 1. This crucial element ensures mutual exclusion when accessing and modifying shared data structures, specifically the queue and reader count. It prevents race conditions by allowing only one thread to modify these structures at any given moment.
- ResourceAvailable: Another semaphore, initially set to 0. This informs writers when the "resource" is free - meaning no other readers or writers are currently active.
- A FIFO (First-In, First-Out) queue that, by design, maintains the chronological order of resource access requests from threads (both readers and writers). This structure is key to ensuring fairness by processing requests in the order they are received.
- ActiveReaders: An integer counter, starting at 0, that keeps track of the number of readers currently accessing the shared resource.

### Explanation of Reader Lock Acquisition:

1. acquireReaderLock:
   - Queue Entry: Each reader must first secure the accessGuard to ensure exclusive access to the queue. The reader adds itself to the queue and then verifies if it's at the front of the queue and if it's the first reader attempting access. If not at the front, it releases the accessGuard and waits on the resourceAvailable semaphore, which will be signaled by either the last departing reader or a writer indicating the resource is available.
   - Access and Dequeue: Once a reader is at the queue's front and it's confirmed safe to proceed (no active writers), the reader increments the activeReaders counter (protected by accessGuard), removes itself from the queue, and signals the resourceAvailable semaphore to allow other waiting readers to proceed. The accessGuard is then released to allow other threads to access the queue.

2. releaseReaderLock:
   - This function is invoked when a reader finishes with the resource. It acquires the accessGuard to safely decrement the activeReaders counter. If this reader is the last one leaving (i.e., activeReaders becomes 0), it signals the resourceAvailable semaphore to notify waiting writers that the resource is now free. The accessGuard is then released.

### Explanation of Writer Lock Acquisition:

1. acquireWriterLock:
   - Queue Entry: Similar to readers, a writer must acquire the accessGuard to access the queue and then enqueues itself. The writer then checks if it is at the front of the queue. If not, it releases the accessGuard and waits on the resourceAvailable semaphore, which indicates that the resource is free and safe for writing.
   - Access and Dequeue: Once at the front of the queue and the resource is free (ensured by the resourceAvailable wait), the writer dequeues itself from the queue, indicating it is now using the resource, and then releases the accessGuard.

2. releaseWriterLock:
   - When the writer is done, it simply signals the resourceAvailable semaphore without needing to acquire the accessGuard, as no shared structures are being modified. This signal informs the next in queue (reader or writer) that the resource is now available and they can proceed.

## Conclusion

This implementation ensures fairness and prevents starvation because requests to access the resource are managed in a FIFO manner using queues. Semaphores provide all the necessary mechanisms for synchronization to coordinate access between multiple readers and writers, allowing the ability to control and predict access patterns. This design allows multiple readers to access the resource concurrently while ensuring writers have exclusive access when their turn comes.

## Pseudocode

```pseudocode
function acquireReaderLock():
    accessGuard.wait()                    # Secure access to the queue
    requestQueue.enqueue(currentThread)   # Add reader to the queue
    while requestQueue.front() != currentThread or activeReaders == 0:
        accessGuard.signal()
        resourceAvailable.wait()          # Wait until safe to read
        accessGuard.wait()
    requestQueue.dequeue()                # Remove reader from queue
    activeReaders += 1                    # Increment active reader count
    resourceAvailable.signal()            # Signal next reader/writer
    accessGuard.signal()                  # Release queue access

function releaseReaderLock():
    accessGuard.wait()          # Secure access to reader count
    activeReaders -= 1          # Decrement active reader count
    if activeReaders == 0:
        resourceAvailable.signal() # Signal resource is free if last reader
    accessGuard.signal()        # Release lock

function acquireWriterLock():
    accessGuard.wait()                    # Secure access to the queue
    requestQueue.enqueue(currentThread)   # Add writer to the queue
    while requestQueue.front() != currentThread:
        accessGuard.signal()
        resourceAvailable.wait()          # Wait until resource is free
    accessGuard.wait()
    requestQueue.dequeue()                # Remove writer from queue
    accessGuard.signal()                  # Release queue access

function releaseWriterLock():
    resourceAvailable.signal()  # Signal resource is free, next in queue can proceed
```
