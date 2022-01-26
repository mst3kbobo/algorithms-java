package com.joemerrill.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth-first Search (DFS) Algorithm
 * <p>Solution:</p>
 * <ol>
 *     <li>Start at root node and call BFS method on the Node.</li>
 *     <li>The node is added to a Queue.</li>
 *     <li>A while loop begins and continues as long as the Queue is not empty.</li>
 *     <li>Inside the while loop, the Node at the head of the Queue is polled (retrieved and removed).</li>
 *     <li>It's name is added to an output array and its children are added to the tail of the Queue.</li>
 *     <li>This continues until the Queue is empty. At which, the entire graph has been explored in a BFS method.</li>
 * </ol>
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {

        /* Build Graph of Nodes

              A
           /  |  \
          B   C   D
         / \     / \
        E   F   G   H
           / \   \
          I   J   K

         */

        // A: Root Node
        BreadthFirstSearch.Node a = new BreadthFirstSearch.Node("A");

        // A's Children
        BreadthFirstSearch.Node b = a.addChild("B");
        a.addChild("C");
        BreadthFirstSearch.Node d = a.addChild("D");

        // B's Children
        b.addChild("E");
        BreadthFirstSearch.Node f = b.addChild("F");

        // F's Children
        f.addChild("I");
        f.addChild("J");

        // D's Children
        BreadthFirstSearch.Node g = d.addChild("G");
        d.addChild("H");

        // G's Children
        g.addChild("K");

        List<String> result = a.breadthFirstSearch();
        System.out.println(result.toString());
    }

    /**
     * Node Class with Breadth-first Search method
     */
    public static class Node {

        private String name;
        private List<Node> children;

        public Node(String name) {
            this.name = name;
            this.children = new ArrayList<Node>();
        }

        public int numberOfChildren() {
            return children.size();
        }

        /**
         * Creates a Node and adds it as a child of the receiver.
         * @param name the name of the Child Node.
         * @return the newly created Child Node.
         */
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return child;
        }

        /**
         * Breadth-first search algorithm.
         * Space Time Complexity (v = vertex, e = edge):
         * Time: O(v+e)
         * Space: O(v)
         *
         * @return List of Nodes traversed via Breadth-first search.
         */
        public List<String> breadthFirstSearch() {

            // arrayList for return
            var outArray = new ArrayList<String>();

            // queue for to add/poll the current node and its children
            Queue<Node> queue = new LinkedList<>();

            queue.add(this);
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                outArray.add(currentNode.name);
                queue.addAll(currentNode.children);
            }

            return outArray;

        }
    }

}
