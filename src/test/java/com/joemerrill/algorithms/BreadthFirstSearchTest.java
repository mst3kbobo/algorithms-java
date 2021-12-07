package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    void breadthFirstSearchGraphTest() {

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
        BreadthFirstSearch.Node c = a.addChild("C");
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

        assertEquals(3, a.numberOfChildren(),
                "The number of child nodes expected for A is incorrect.");
        assertEquals(0, c.numberOfChildren(),
                "The number of child nodes expected for C is incorrect.");

        List<String> result = a.breadthFirstSearch();
        assertEquals("[A, B, C, D, E, F, G, H, I, J, K]", result.toString());

    }

}