package com.joemerrill.datastructures;

/**
 * This program demonstrates a simple Doubly/Bidirectional Linked List
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(String data) {

        Node currentHead = head;
        Node newHead = new Node(data);

        // List is not empty, set new head and update current head.
        if (currentHead != null) {
            currentHead.setPrevious(newHead);
            newHead.setNext(currentHead);
        }
        head = newHead;

        // List was empty, set tail to new head indicating one node in list.
        if (tail == null) {
            tail = newHead;
        }
    }

    public void addToTail(String data) {

        Node currentTail = tail;
        Node newTail = new Node(data);

        // List is not empty, set new tail and update current tail.
        if (currentTail != null) {
            currentTail.setNext(newTail);
            newTail.setPrevious(currentTail);
        }
        tail = newTail;

        // List was empty, set head to new tail indicating one node in list
        if (head == null) {
            head = newTail;
        }
    }

    public String removeHead() {

        // If the list is empty, meaning the head is null, then return null as there is no work to do.
        if (head == null) {
            return null;
        }

        // Set list's head to the removed head's next node.
        Node removedHead = head;
        head = removedHead.getNext();

        // Check if the head is not null, meaning the list had more than one element prior to removal, and if so,
        // set the new head's previous to null.
        if (head != null) {
            head.setPrevious(null);
        }

        // Finally, if the removed head is also the tail, call remove head.
        if (removedHead == tail) {
            this.removeTail();
        }

        return removedHead.getData();
    }

    public String removeTail() {

        // If the list is empty, meaning the tail is null, then return null as there is no work to do.
        if (tail == null) {
            return null;
        }

        // Set list's tail to the removed tail's previous node.
        Node removedTail = tail;
        tail = removedTail.getPrevious();

        // Check if the tail is not null, meaning the list had more than one element prior to removal, and if so,
        // set the new tail's next to null.
        if (tail != null) {
            tail.setNext(null);
        }

        // Finally, if the removed tail is also the head, call remove head.
        if (removedTail == head) {
            this.removeHead();
        }

        return removedTail.getData();
    }

    public Node removeByData(String data) {

        Node nodeToRemove = null;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData() == data) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (nodeToRemove == null) {
            return null;
        }

        if (nodeToRemove == head) {
            this.removeHead();
        } else if (nodeToRemove == tail) {
            // Using 'else if' because removeHead() will call removeTail() if head is tail.
            this.removeTail();
        } else {
            Node nextNode = nodeToRemove.getNext();
            Node previousNode = nodeToRemove.getPrevious();
            nextNode.setPrevious(previousNode);
            previousNode.setNext(nextNode);
        }

        return nodeToRemove;
    }

    public String printList() {

        String output = "{HEAD} <-> ";

        Node currentNode = head;

        while (currentNode != null) {
            output += currentNode.getData();
            output += " <-> ";
            currentNode = currentNode.getNext();
        }

        output += "{TAIL}";

        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {

        DoublyLinkedList subway = new DoublyLinkedList();
        subway.printList();

        subway.addToHead("Times Square");
        subway.addToHead("Grand Central");
        subway.addToHead("Central Park");
        subway.printList();

        subway.addToTail("Penn Station");
        subway.addToTail("Wall Street");
        subway.addToTail("Brooklyn Bridge");
        subway.printList();

        subway.removeHead();
        subway.removeTail();
        subway.printList();

        subway.removeByData("Times Square");
        subway.printList();
    }
}
