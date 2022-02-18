package com.joemerrill.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void print() {
        print(this.root, 0);
    }

    private void print(TreeNode currentNode, int level) {
        String levelIndentation = "";
        for (int i = 0; i < level; i++) {
            levelIndentation += "-- ";
        }
        System.out.println(levelIndentation + currentNode.getData());
        for (TreeNode child : currentNode.getChildren()) {
            print(child, level + 1);
        }
    }

    public void depthFirstTraversal(TreeNode current) {
        // 1) Display the current tree node's data
        // 2) For each child in children
        //    2a) Call DFS traversal recursively on child
        System.out.print(current.getData() + " ");
        for (TreeNode child : current.getChildren()) {
            depthFirstTraversal(child);
        }
    }

    public void breadthFirstTraversal() {
        // 1) Create a queue
        // 2) Initialize by adding the root node
        // 3) While the queue is not empty
        //    3a) Set the first tree node from the queue as current
        //    3b) Print current tree node's data
        //    3c) Add all current tree node's children to the queue

        TreeNode current = this.root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.getData() + " ");
            queue.addAll(current.getChildren());
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                "}";
    }

    public static void main(String[] args) {

        TreeNode h = new TreeNode("h");
        TreeNode e = new TreeNode("e");
        TreeNode l1 = new TreeNode("l");
        TreeNode l2 = new TreeNode("l");
        TreeNode o = new TreeNode("o");
        h.addChild(e);
        h.addChild(l1);
        e.addChild(l2);
        l1.addChild(o);

        Tree letters = new Tree(h);
        letters.print();

        //
        // Depth First Traversal
        //
        System.out.println("\nDepth First Traversal:");
        letters.depthFirstTraversal(h);

        //
        // Breadth First Traversal
        //
        System.out.println("\nBreadth First Traversal:");
        letters.breadthFirstTraversal();

        //
        //
        //
        System.out.println("\n");
        TreeNode animals = new TreeNode("Animals");
        TreeNode reptile = new TreeNode("Reptiles");
        TreeNode mammals = new TreeNode("Mammals");
        animals.addChild(reptile);
        animals.addChild(mammals);
        reptile.addChild("Lizard");
        reptile.addChild("Snake");
        TreeNode equine = new TreeNode("Equine");
        TreeNode bovine = new TreeNode("Bovine");
        TreeNode marsupial = new TreeNode("Marsupial");
        mammals.addChild(equine);
        mammals.addChild(bovine);
        mammals.addChild(marsupial);
        equine.addChild("Horse");
        equine.addChild("Zebra");
        bovine.addChild("Husky");
        marsupial.addChild("Koala");

        Tree animalTree = new Tree(animals);

        // Add and remove accordingly
        bovine.removeChild("Husky");
        bovine.addChild("Cow");
        marsupial.addChild("Kangaroo");

        animalTree.print();
    }
}
