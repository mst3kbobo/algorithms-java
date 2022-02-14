package com.joemerrill.datastructures;

/**
 * This program demonstrates a Queue
 */
public class Queue {

    public static final String OVERFLOW_ERROR_MESSAGE = "Overflow error. Queue is full and enqueue cannot occur.";
    public static final String UNDERFLOW_ERROR_MESSAGE = "Underflow error. Queue is empty and dequeue cannot occur.";

    public static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    private LinkedList queue;
    private int size;
    private int maxSize;

    /**
     * Queue Constructor - creates an unbounded queue
     */
    public Queue() {
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * Queue Constructor - creates a bounded queue
     * @param maxSize maximum size (bounds) of the queue
     */
    public Queue(int maxSize) {
        this.queue = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    /**
     * Enqueue (add) data at back/tail of the queue.
     * @param data data to add
     */
    public void enqueue(String data) {

        // Prevent overflow
        if (!hasSpace()) {
            throw new Error(OVERFLOW_ERROR_MESSAGE);
        }

        queue.addToTail(data);
        size += 1;
        System.out.println("Added \"" + data + "\". Queue size is now " + size + ".");
    }

    /**
     * Dequeue (remove) and return data at front/head of queue.
     * @return String data at front of the queue if not empty. Otherwise, throws on empty queue.
     */
    public String dequeue() {

        // Prevent underflow
        if (isEmpty()) {
            throw new Error(UNDERFLOW_ERROR_MESSAGE);
        }

        String data = queue.removeHead();
        size -= 1;
        System.out.println("Removed \"" + data + "\". Queue size is now " + size + ".");
        return data;
    }

    /**
     * Peek at data at front/head of the queue. Does not remove data.
     * @return String data at front of the queue if not empty. Otherwise, returns null.
     */
    public String peek() {
        return isEmpty() ? null : queue.getHead().getData();
    }

    /**
     * Helper method to determine if the queue has space to push data onto the stack. Used for overflow check.
     * @return True if there is space. Otherwise, false.
     */
    public boolean hasSpace() {
        return size < maxSize;
    }

    /**
     * Helper method to determine if the queue is empty. E.g., its size is equal to 0. Used for underflow check.
     * @return True if empty. Otherwise, false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue=" + queue +
                ", size=" + size +
                ", maxSize=" + maxSize +
                "}";
    }

    public static void main(String[] args) {

        Queue queueOne = new Queue();
        System.out.println(queueOne);

        //
        // Test Enqueue
        //
        Queue queueTwo = new Queue(10);
        System.out.println(queueTwo);
        queueTwo.enqueue("latte");
        queueTwo.enqueue("espresso");
        queueTwo.enqueue("cappuccino");
        System.out.println(queueTwo);

        //
        // Test Dequeue
        //
        Queue iceCreamShop = new Queue();
        iceCreamShop.enqueue("mint chip");
        iceCreamShop.enqueue("chocolate");
        iceCreamShop.dequeue();
        iceCreamShop.enqueue("strawberry");
        System.out.println(iceCreamShop);
        iceCreamShop.dequeue();
        iceCreamShop.dequeue();
        System.out.println("All orders are complete!");

        //
        // Test Overflow and Underflow errors
        //
        Queue boundedQueue = new Queue(3);
        boundedQueue.enqueue("one");
        boundedQueue.enqueue("two");
        System.out.println("Peek: " + boundedQueue.peek());
        boundedQueue.enqueue("three");
        // boundedQueue.enqueue("four"); // Overflow error
        boundedQueue.dequeue();
        boundedQueue.dequeue();
        System.out.println("Peek: " + boundedQueue.peek());
        boundedQueue.dequeue();
        // boundedQueue.dequeue(); // Underflow error

    }
}
