package com.joemerrill.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution:
 * 1) Start at root node and call DFS method on the Node. Add it to the final output list.
 * 2) Explore the children of that node and call the DSF method on them passing in the final output list.
 */
public class DepthFirstSearch {

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
        DepthFirstSearch.Node a = new DepthFirstSearch.Node("A");

        // A's Children
        DepthFirstSearch.Node b = a.addChild("B");
        a.addChild("C");
        Node d = a.addChild("D");

        // B's Children
        b.addChild("E");
        DepthFirstSearch.Node f = b.addChild("F");

        // F's Children
        f.addChild("I");
        f.addChild("J");

        // D's Children
        DepthFirstSearch.Node g = d.addChild("G");
        d.addChild("H");

        // G's Children
        g.addChild("K");

        List<String> result = a.depthFirstSearch(new ArrayList<String>());
        System.out.println(result.toString());
    }

    /**
     * Node Class
     * with Depth-first Search method
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
         * Depth-first search algorithm.
         * Space Time Complexity (v = vertex, e = edge):
         * Time: O(v+e)
         * Space: O(v)
         *
         * @return List of all explored vertices (nodes)
         */
        public List<String> depthFirstSearch(List<String> arrayList) {
            arrayList.add(this.name);
            for (Node child : this.children) {
                child.depthFirstSearch(arrayList);
            }
            return arrayList;
        }
    }
}
