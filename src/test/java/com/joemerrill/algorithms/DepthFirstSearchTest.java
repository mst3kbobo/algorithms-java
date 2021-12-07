package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    public void depthFirstSearchGraphTest() {

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
        DepthFirstSearch.Node c = a.addChild("C");
        DepthFirstSearch.Node d = a.addChild("D");

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

        assertEquals(3, a.numberOfChildren(),
                "The number of child nodes expected for A is incorrect.");
        assertEquals(0, c.numberOfChildren(),
                "The number of child nodes expected for C is incorrect.");

        List<String> result = a.depthFirstSearch(new ArrayList<String>());
        assertEquals("[A, B, E, F, I, J, C, D, G, K, H]", result.toString());
    }

}