package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    private final String TAG = "TreeNodeTest";
    TreeNode rootNode;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);

        rootNode = new TreeNode("a");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);

        rootNode = null;
        assertNull(rootNode);
    }

    @Test
    void getData() {
        assertEquals("a", rootNode.getData());
    }

    @Test
    void setData() {
        rootNode.setData("b");
        assertEquals("b", rootNode.getData());
    }

    @Test
    void getChildren() {

        assertEquals(new ArrayList<TreeNode>(), rootNode.getChildren());

        TreeNode b = new TreeNode("b");
        rootNode.addChild(b);
        assertEquals(new ArrayList<TreeNode>(List.of(b)),
                rootNode.getChildren());
    }

    @Test
    void childrenSize() {
        assertEquals(0, rootNode.childrenSize());
        rootNode.addChild("b");
        assertEquals(1, rootNode.childrenSize());
    }

    @Test
    void hasChildren() {
        assertFalse(rootNode.hasChildren());
        rootNode.addChild("b");
        assertTrue(rootNode.hasChildren());
    }

    @Test
    void containsChild() {
        TreeNode b = new TreeNode("b");
        rootNode.addChild(b);
        assertTrue(rootNode.containsChild(b));
    }

    @Test
    void addChild() {

        // Add child via new TreeNode
        TreeNode b = new TreeNode("b");
        rootNode.addChild(b);
        assertTrue(rootNode.containsChild(b));
        assertEquals(1, rootNode.childrenSize());

        // Add child via Object data
        TreeNode c = new TreeNode("c");
        rootNode.addChild(c);
        assertTrue(rootNode.containsChild(c));
        assertEquals(2, rootNode.childrenSize());
    }

    @Test
    void removeChild() {

        // Remove child via TreeNode
        TreeNode b = new TreeNode("b");
        rootNode.addChild(b);
        assertTrue(rootNode.containsChild(b));
        rootNode.removeChild(b);
        assertFalse(rootNode.containsChild(b));

        // Remove child via Object data
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        rootNode.addChild(c);
        c.addChild("d");
        rootNode.addChild(d);
        d.addChild(e);
        rootNode.removeChild("d");
        assertFalse(rootNode.containsChild(d));
        assertFalse(rootNode.containsChild(e));
        rootNode.removeChild("c");
        assertFalse(rootNode.containsChild(c));
    }
}