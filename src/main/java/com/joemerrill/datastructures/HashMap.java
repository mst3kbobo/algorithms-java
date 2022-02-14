package com.joemerrill.datastructures;

import java.util.Arrays;

/**
 * This program demonstrates a Hash Map
 * Uses the nested/inner Linked List and Node classes for separate chaining collision strategy.
 */
public class HashMap {

    private LinkedList[] hashMap;

    public HashMap(int size) {
        this.hashMap = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.hashMap[i] = new LinkedList();
        }
    }

    /**
     * Hash method for a String key
     * @param key String key to hash
     * @return integer representing the index of the array to store the key-value pair
     */
    private int hash(String key) {

        int hashCode = 0;

        for (int i = 0; i < key.length(); i++) {
            hashCode += Character.codePointAt(key, i);
        }

        // Compress hashCode so it fits in within the index range of the hash map.
        hashCode = hashCode % hashMap.length;

        return hashCode;
    }

    public void assign(String key, String value) {

        int arrayIndex = hash(key);

        // Get the linked list at the array's index.
        LinkedList list = hashMap[arrayIndex];

        // If the linked list is empty, add the new key-value pair and return.
        if (list.getHead() == null) {
            list.addToHead(key, value);
            return;
        }

        // Otherwise, loop through the linked list and
        //   1) check if the key already exists and overwrite
        //   2) check if current node is the tail and if so, set next node to the new key-value pair, then break
        //   3) if key does not match (1) and not at tail (2) set current to next and iterate
        Node current = list.getHead();

        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setKeyValue(key, value);
            }
            if (current.getNext() == null) {
                current.setNext(new Node(key, value));
                break;
            }
            current = current.getNext();
        }
    }

    public String retrieve(String key) {
        int arrayIndex = this.hash(key);

        // Get the linked list at the array's index.
        LinkedList list = hashMap[arrayIndex];

        // loop through the linked list to find key
        Node current = list.getHead();
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            } else {
                current = current.getNext();
            }
        }

        return null;
    }

    public static void main(String[] args) {

        HashMap myMap = new HashMap(5);

        //
        // Hash Test
        //
        System.out.println(myMap.hash("c"));
        System.out.println(myMap.hash("ca"));
        System.out.println(myMap.hash("car"));

        //
        // Assign Test
        //
        System.out.println(myMap.hash("1F012345678901234"));
        myMap.assign("1F012345678901234", "Ford Bronco");
        System.out.println(Arrays.toString(myMap.hashMap));

        //
        // Retrieve Test
        //
        System.out.println(myMap.retrieve("1F012345678901234"));

        //
        // Collision Test
        //
        myMap.assign("1F9876543210", "Ford F-150");
        myMap.assign("1F5555555555", "Ford Mustang");
        myMap.assign("1F0000000000", "Ford Ranger");
        myMap.assign("1F0000001000", "Ford Maverick");
        System.out.println(Arrays.toString(myMap.hashMap));
        System.out.println(myMap.retrieve("1F9876543210"));
        System.out.println(myMap.retrieve("1F5555555555"));
        System.out.println(myMap.retrieve("1F0000000000"));
    }

    private class LinkedList {

        private Node head;

        public LinkedList() {
            this.head = null;
        }

        public Node getHead() {
            return head;
        }

        public void addToHead(String key, String value) {

            Node currentHead = head;

            Node newHead = new Node(key, value);
            head = newHead;

            if (currentHead != null) {
                head.setNext(currentHead);
            }
        }

        public void addToTail(String key, String value) {

            Node tail = head;
            if (tail == null) {
                head = new Node(key, value);
            } else {
                while (tail.hasNext()) {
                    tail = tail.getNext();
                }
                tail.setNext(new Node(key, value));
            }
        }

        public void removeHead() {
            Node removedHead = head;
            if (head != null) {
                head = removedHead.getNext();
            }
        }

        @Override
        public String toString() {
            return "LinkedList{" +
                    "head=" + head +
                    "}";
        }
    }

    private class Node {

        private String key;
        private String value;
        private Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setKeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", next=" + next +
                    "}";
        }
    }

}
