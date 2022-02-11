package com.joemerrill.datastructures;

public class Node {

    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {

        Node firstNode = new Node("I am a Node!");

        System.out.println(firstNode.data);
        System.out.println(firstNode.next);

        Node secondNode = new Node("I am the second Node!");

        firstNode.setNext(secondNode);

        System.out.println(firstNode.getNext().data); // Possible to access next and data fields because main method is in Node class.

        //
        // Ice Cream Shop
        //

        Node strawberry = new Node("Berry Tasty");
        Node banana = new Node("Banana-rama");
        Node coconut = new Node("Nuts for Coconut");

        strawberry.setNext(banana);
        banana.setNext(coconut);

        Node currentNode = strawberry;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.getNext();
        }

    }
}
