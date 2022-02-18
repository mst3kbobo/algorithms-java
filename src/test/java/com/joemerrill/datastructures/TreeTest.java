package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    private final String TAG = "TreeTest";
    Tree treeOne;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);

        TreeNode h = new TreeNode("h");
        TreeNode e = new TreeNode("e");
        TreeNode l1 = new TreeNode("l");
        TreeNode l2 = new TreeNode("l");
        TreeNode o = new TreeNode("o");
        h.addChild(e);
        h.addChild(l1);
        e.addChild(l2);
        l1.addChild(o);

        Tree treeOne = new Tree(h);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);

        treeOne = null;
        assertNull(treeOne);
    }

    @Test
    void depthFirstSearch() {

    }

    @Test void breadthFirstSearch() {

    }

}