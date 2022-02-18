package com.joemerrill.datastructures;

import java.util.ArrayList;

public class TreeNode {

    private Object data;
    private ArrayList<TreeNode> children;

    public TreeNode(Object data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public int childrenSize() {
        return children.size();
    }

    public boolean containsChild(TreeNode child) {
        return children.contains(child);
    }

    /**
     * Add Child Node to Current Node using a new TreeNode
     * @param child TreeNode child to add
     */
    public void addChild(TreeNode child) {
        children.add(child);
    }

    /**
     * Add Child Node to Current Node using data.
     * @param childData Data to add
     */
    public void addChild(Object childData) {
        children.add(new TreeNode(childData));
    }

    /**
     * Find and Remove Child Node from Current Node using a TreeNode
     * @param childToRemove TreeNode child to remove
     */
    public void removeChild(TreeNode childToRemove) {
        if (children.isEmpty()) {
            return;
        } else if (children.contains(childToRemove)) {
            children.remove(childToRemove);
            return;
        } else {
            for (TreeNode child : children) {
                child.removeChild(childToRemove);
            }
        }
    }

    /**
     * Find and Remove Child Node from Current Node using Data
     * Note the following:
     * 1) all child nodes matching the target data will be removed.
     * 2) descendants of the removed node(s) are also removed.
     * 3) children of a removed node are not moved up the tree.
     * @param targetData TreeNode child to remove
     */
    public void removeChild(Object targetData) {
        if (children.isEmpty()) {
            return;
        }
        for (TreeNode child : children) {
            if (child.getData().equals(targetData)) {
                children.remove(child);
                return;
            }
        }
        for (TreeNode child : children) {
            child.removeChild(targetData);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", childCount=" + childrenSize() +
                ", children=" + children +
                "}";
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.addChild(15);

        System.out.println(root.childrenSize());

        TreeNode biggerChild = new TreeNode(30);
        root.addChild(biggerChild);
        System.out.println(root.childrenSize());

        System.out.println(root.getData());

        System.out.println(root);
    }
}
