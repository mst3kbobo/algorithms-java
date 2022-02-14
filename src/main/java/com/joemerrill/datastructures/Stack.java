package com.joemerrill.datastructures;

/**
 * This program demonstrates a Stack
 */
public class Stack {

    public static final String OVERFLOW_ERROR_MESSAGE = "Overflow error. Stack is full and push cannot occur.";
    public static final String UNDERFLOW_ERROR_MESSAGE = "Underflow error. Stack is empty and pop cannot occur.";

    public static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    private LinkedList stack;
    private int size;
    private int maxSize;

    /**
     * Stack Constructor - creates an unbounded stack
     */
    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * Stack Constructor - creates a bounded stack
     * @param maxSize maximum size (bounds) of the stack
     */
    public Stack(int maxSize) {
        this.stack = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    /**
     * Push (add) data on top of stack.
     * @param data data to add
     */
    public void push(String data) {

        // Prevent overflow
        if (!hasSpace()) {
            throw new Error(OVERFLOW_ERROR_MESSAGE);
        }

        stack.addToHead(data);
        size += 1;
        System.out.println("Added \"" + data + "\". Stack size is now " + size + ".");
    }

    /**
     * Pop (remove) and return data on top of stack.
     * @return String data on top of the stack if not empty. Otherwise, throws on empty stack.
     */
    public String pop() {

        // Prevent underflow
        if (isEmpty()) {
            throw new Error(UNDERFLOW_ERROR_MESSAGE);
        }

        String data = stack.removeHead();
        size -= 1;
        System.out.println("Removed \"" + data + "\". Stack size is now " + size + ".");
        return data;
    }

    /**
     * Peek at data on top of the stack. Does not remove data.
     * @return String data on top of the stack if not empty. Otherwise, returns null.
     */
    public String peek() {
        return stack.getHead().getData();
    }

    /**
     * Helper method to determine if the stack has space to push data onto the stack. Used for overflow check.
     * @return True if there is space. Otherwise, false.
     */
    public boolean hasSpace() {
        return size < maxSize;
    }

    /**
     * Helper method to determine if the stack is empty. E.g., its size is equal to 0. Used for underflow check.
     * @return True if empty. Otherwise, false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                ", size=" + size +
                ", maxSize=" + maxSize +
                "}";
    }

    public static void main(String[] args) {

        Stack myStack = new Stack(3);
        System.out.println(myStack);

        //
        // Test Push
        //
        Stack dishes = new Stack();
        dishes.push("blue plate");
        dishes.push("red plate");
        dishes.push("glass serving bowl");
        System.out.println(dishes);

        //
        // Test Pop and Peek
        //
        Stack myMedals = new Stack();
        myMedals.push("silver");
        myMedals.push("gold");
        System.out.println("Peek: " + myMedals.peek());
        myMedals.push("bronze");
        System.out.println(myMedals);
        myMedals.pop();
        myMedals.pop();
        System.out.println(myMedals);

        //
        // Test Overflow and Underflow errors
        //
        Stack driveWay = new Stack(2);
        driveWay.push("blue truck");
        driveWay.push("red coupe");
        // driveWay.push("yellow bus"); // Overflow error
        driveWay.pop();
        driveWay.pop();
        // driveWay.pop(); // Underflow error

    }
}
