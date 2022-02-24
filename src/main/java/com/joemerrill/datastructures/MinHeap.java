package com.joemerrill.datastructures;

import java.util.ArrayList;
import java.util.Random;

/**
 * MinHeap
 * Must satisfy the following:
 * 1) The element at index 0 is the minimum value in the entire ArrayList.
 * 2) Every child element in the ArrayList must be larger than its parent.
 *
 * Uses an ArrayList for storing elements, but models heap behavior on a binary tree.
 * Child and parent elements are determined by their relative indices within the heap.
 */
public class MinHeap {

    public static final String MINHEAP_EMPTY_ERROR_MESSAGE = "MinHeap is empty. Pop cannot occur.";

    private ArrayList<Integer> heap;
    private int size;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
        this.size = 0;
    }

    public ArrayList<Integer> getHeap() {
        return heap;
    }

    public int getSize() {
        return size;
    }

    public void add(int value) {
        heap.add(value);
        System.out.println("Adding value: " + value + "\n" + heap);
        size += 1;
        bubbleUp();
    }

    public int popMin() {

        if (size == 0) {
            throw new Error(MINHEAP_EMPTY_ERROR_MESSAGE);
        }

        System.out.println("Swap min element " + heap.get(0) +
                " and last element " + heap.get(size - 1));

        // Swap the first index (minimum) with last index for easy removal from ArrayList.
        int lastIndex = getSize() - 1;
        swap(0, lastIndex);

        int minimum = heap.remove(lastIndex);
        size -= 1;

        heapify();

        System.out.println("Removed from the heap: " + minimum);

        return minimum;
    }

    /**
     * After adding an element to the end of the heap,
     * bubble up and swap with the element's parent to maintain a min heap's conditions.
     */
    private void bubbleUp() {

        // Parent: (index - 1) / 2 (rounded down)
        // Left child: (index * 2) + 1
        // Right child: (index * 2) + 2

        int currentIndex = size - 1;

        // Loop while there is a valid current index (> 0) and
        // the element at the current index is < its parent value.
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(getParentIndex(currentIndex))) {

            System.out.println("Swap current index " + currentIndex +
                    " with parent index " + getParentIndex(currentIndex));

            swap(currentIndex, getParentIndex(currentIndex));

            // Set current index to parent index in case more swapping needs to occur.
            currentIndex = getParentIndex(currentIndex);
        }
    }

    /**
     * After popping an element from the end of the heap,
     * heapify (bubble down) and swap with the left or right child to maintain the min heap's conditions.
     */
    private void heapify() {

        int currentIndex = 0; // Start with Root
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);

        while (canSwap(currentIndex, leftChildIndex, rightChildIndex)) {

            if (exists(leftChildIndex) && exists(rightChildIndex)) {
                if (heap.get(leftChildIndex) < heap.get(rightChildIndex)) {
                    swap(currentIndex, leftChildIndex);
                    currentIndex = leftChildIndex;
                } else {
                    swap(currentIndex, rightChildIndex);
                    currentIndex = rightChildIndex;
                }
            } else {
                swap(currentIndex, leftChildIndex);
                currentIndex = leftChildIndex;
            }

            leftChildIndex = getLeftChildIndex(currentIndex);
            rightChildIndex = getRightChildIndex(currentIndex);
        }
    }

    /**
     * Swaps the elements found at the provided indices.
     * @param a Index A of the swap.
     * @param b Index B of the swap.
     */
    private void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    private boolean canSwap(int current, int leftChild, int rightChild) {
        // if (leftChild exists AND is less than its parent), return true
        // OR
        // if (rightChild exists AND is less than its parent), return true
        // else, return false
        return (exists(leftChild) && (heap.get(leftChild) < heap.get(current))) ||
                (exists(rightChild) && (heap.get(rightChild) < heap.get(current)));
    }

    private boolean exists(int index) {
        return index < heap.size();
    }

    /**
     * Retrieve the parent index of the current element's index.
     * Not used on the root since its index is 0. 0 will be returned if called on root.
     * @param currentIndex index of the current element
     * @return index of the current element's parent
     */
    public int getParentIndex(int currentIndex) {
        return (currentIndex == 0) ? 0 : (int) Math.floor((currentIndex - 1) / 2);
    }

    public int getLeftChildIndex(int currentIndex) {
        return (currentIndex * 2) + 1;
    }

    public int getRightChildIndex(int currentIndex) {
        return (currentIndex * 2) + 2;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Populate minHeap with 6 random numbers
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            System.out.println("-------------");
            minHeap.add(rand.nextInt(40));
        }

        // Display the heap after bubbling up
        System.out.println("-------------");
        System.out.println("BUBBLED UP: " + minHeap.heap);

        System.out.println("-------------");

        // Remove/pop minimum value multiple times
        for (int i = 0; i < 6; i++) {
            System.out.println("--------------");
            System.out.println("POP MIN: " + minHeap.popMin());
            System.out.println("HEAPIFIED: " + minHeap.heap);
        }
    }

}
