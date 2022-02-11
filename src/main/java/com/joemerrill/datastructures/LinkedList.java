package com.joemerrill.datastructures;

/**
 * This program demonstrates a simple Singly Linked List
 */
public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
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

    public String printList() {

        String output = "{HEAD} -> ";

        Node currentNode = head;

        while (currentNode != null) {
            output += currentNode.getData();
            output += " -> ";
            currentNode = currentNode.getNext();
        }

        output += "{TAIL}";

        System.out.println(output);

        return output;
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
    }
}
