package com.joemerrill.datastructures;

/**
 * This program demonstrates a simple Singly Linked List
 */
public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void addToHead(String data) {

        Node currentHead = head;

        Node newHead = new Node(data);
        head = newHead;

        if (currentHead != null) {
            head.setNext(currentHead);
        }
    }

    public String removeHead() {

        Node removedHead = head;
        if (head == null) {
            return null;
        }
        head = removedHead.getNext();
        return removedHead.getData();
    }

    public void addToTail(String data) {

        // First set a temporary tail node equal to the current head node.
        // The list is empty if the node is null. Therefore, add the node to the head of the list.
        // Otherwise, iterate through the list until we find the last node (e.g., there is no next).
        // Once found, add a pointer (next) from that node to the new tail.
        Node tail = head;
        if (tail == null) {
            head = new Node(data);
        } else {
            while (tail.hasNext()) {
                tail = tail.getNext();
            }
            tail.setNext(new Node(data));
        }
    }

    /**
     * Swap DataA with DataB if found in the linked list.
     * Complexity Analysis:
     * - Time: O(n) for iteration through list. dataA or dataB may not be in the list or at the tail.
     * - Space: O(1) variables to keep track of nodes
     * @param dataA String to swap with dataB
     * @param dataB String to swap with dataA
     */
    public void swap(String dataA, String dataB) {

        System.out.println("Swapping \"" +
                dataA +
                "\" with \"" +
                dataB +
                "\".");

        // EDGE CASE
        // Requested data to swap is identical. Although the swap can still be completed, there is no need to do this work.
        if (dataA.equals(dataB)) {
            System.out.println("Requested data to be swapped is the same. No need to perform the swap.");
            return;
        }

        // Variables for tracking nodes to swap and their previous nodes.
        Node nodeA = head;
        Node nodeB = head;
        Node nodeAPrevious = null;
        Node nodeBPrevious = null;

        // Used to search list in a single while loop versus separate loops for each node to find.
        boolean dataAFound = false;
        boolean dataBFound = false;

        // Loop until nodes matching data are found. Keep track of previous nodes to found nodes.
        while (nodeA != null && nodeB != null) {

            if (nodeA.getData().equals(dataA)) {
                dataAFound = true;
            }

            if (nodeB.getData().equals(dataB)) {
                dataBFound = true;
            }

            // Break out of loop because both dataA and dataB were found on the previous iteration.
            if (dataAFound && dataBFound) {
                break;
            }

            if (!dataAFound) {
                nodeAPrevious = nodeA;
                nodeA = nodeA.getNext();
            }

            if (!dataBFound) {
                nodeBPrevious = nodeB;
                nodeB = nodeB.getNext();
            }
        }

        // EDGE CASE
        // One of the nodes is null. This means we iterated through the list and was unable to find dataA or dataB as
        // the getNext() method would eventually find the tail with a null next.
        if (nodeA == null || nodeB == null) {
            System.out.println("Swap is not possible as one or more of the nodes was not found in the list.");
            return;
        }

        //
        // Perform Swap (Update Previous Pointers)
        //
        // If the previous Node to NodeA was null, then NodeA is the head and NobeB should be made the head.
        // Otherwise, the previous Node to NodeA should be set to NodeB to start the swap.
        if (nodeAPrevious == null) {
            head = nodeB;
        } else {
            nodeAPrevious.setNext(nodeB);
        }

        if (nodeBPrevious == null) {
            head = nodeA;
        } else {
            nodeBPrevious.setNext(nodeA);
        }

        //
        // Perform Swap (Update Next Pointers)
        //
        Node temp = nodeA.getNext();
        nodeA.setNext(nodeB.getNext());
        nodeB.setNext(temp);
    }

    @Override
    public String toString() {

        String output = "LinkedList{<HEAD> -> ";

        Node currentNode = head;

        while (currentNode != null) {
            output += currentNode.getData();
            output += " -> ";
            currentNode = currentNode.getNext();
        }

        output += "<TAIL>}";

        return output;
    }

    public String printList() {

        String output = toString();

        System.out.println(output);

        return output;
    }

    /**
     * Find the nth last node in the linked list.
     * - Time: O(n) for full iteration through list
     * - Space: O(1) variables to keep track of nodes
     * @param number nth last node to find. (e.g., 5 would be the 5th from last node)
     * @return node at nth last position, null if number is greater than length of list.
     */
    public Node nthLastNode(int number) {

        Node tailTracker = head;
        Node nthTracker = null;
        int counter = 0;

        // Delay the nth tracker behind the tail tracker by the request number.
        while (tailTracker != null) {
            tailTracker = tailTracker.getNext();
            if (counter >= number) {
                if (nthTracker == null) {
                    nthTracker = head;
                }
                nthTracker = nthTracker.getNext();
            }
            counter += 1;
        }

        return nthTracker;
    }

    /**
     * Find the middle node in the linked list. If there is an even amount of nodes in the list, this method will return
     * the node at the beginning of the 2nd half. (E.g., A->B->C->D will return C)
     * - Time: O(n) for full iteration through list
     * - Space: O(1) variables to keep track of nodes
     * @return Middle Node in the linked list.
     */
    public Node middleNode() {

        Node tailTracker = head;
        Node middleTracker = head;

        // Move tail tracker at twice the rate of the middle tracker.
        while (tailTracker != null) {
            tailTracker = tailTracker.getNext();
            if (tailTracker != null) {
                tailTracker = tailTracker.getNext();
                middleTracker = middleTracker.getNext();
            }
        }

        return middleTracker;
    }

    /**
     * Iterative approach to finding a node based on input data.
     * @param data Node to find based on the String data passed to the method.
     * @return Node if found in the linked list. Otherwise, null.
     */
    public Node findNodeIteratively(String data) {
        Node current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    /**
     * Recursive approach to finding a node based on input data.
     * @param data Node to find based on the String data passed to the method.
     * @param currentNode Current Node to check. Typically the head node of the list when starting the recursive search.
     * @return Node if found in the linked list. Otherwise, null.
     */
    public Node findNodeRecursively(String data, Node currentNode) {

        if (currentNode == null) {
            return null; // Base Case 1: Tail of List
        } else if (currentNode.getData().equals(data)) {
            return currentNode; // Base Case 2: Found Node
        } else {
            return findNodeRecursively(data, currentNode.getNext()); // Recursive Case
        }
    }

    public static void main(String[] args) {

        LinkedList seasons = new LinkedList();
        seasons.printList();

        seasons.addToHead("summer");
        seasons.addToHead("spring");
        seasons.printList();

        seasons.addToTail("fall");
        seasons.addToTail("winter");
        seasons.printList();

        String removedNodeData = seasons.removeHead();
        System.out.println("Removed Node Data: " + removedNodeData);
        seasons.printList();

        //
        // Swap Test
        //
        LinkedList swapNumbersTest = new LinkedList();
        for (int i = 0; i <= 5; i++) {
            swapNumbersTest.addToTail(Integer.toString(i));
        }

        swapNumbersTest.printList();
        swapNumbersTest.swap("2", "4");
        swapNumbersTest.printList();

        //
        // Two Pointers (Runner Technique)
        //
        LinkedList numbers = new LinkedList();
        for (int i = 0; i <= 20; i++) {
            numbers.addToTail(Integer.toString(i));
        }

        numbers.printList();

        Node fifthFromLastNode = numbers.nthLastNode(5);
        System.out.println("5th From Last Node Data: " + fifthFromLastNode.getData());

        Node middleNode = numbers.middleNode();
        System.out.println("Middle Node Data: " + middleNode.getData());

        //
        // Find Nodes Iteratively and Recursively
        //
        // Find Node iteratively:
        LinkedList test = new LinkedList();
        test.addToHead("one");
        test.addToTail("two");
        test.addToTail("three");
        test.addToTail("four");
        Node foundNodeIterative = test.findNodeIteratively("three");
        System.out.println("foundNodeIterative: " + foundNodeIterative.getData());
        Node foundNodeRecursive = test.findNodeIteratively("two");
        System.out.println("foundNodeRecursive: " + foundNodeRecursive.getData());
    }
}
