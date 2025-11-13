package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0,1,4);
        g.addEdge(0,2,3);
        g.addEdge(1,2,1);
        g.addEdge(1,3,2);
        g.addEdge(2,3,4);
        g.addEdge(3,4,2);
        g.addEdge(4,5,6);

        System.out.println("Original MST:");
        List<Edge> mst = Prim.buildMST(g);
        mst.forEach(System.out::println);

        Edge removed = mst.get(2);
        System.out.println("\nRemoved edge: " + removed);

        int[] comp = Prim.findComponents(g.size(), mst, removed);

        System.out.println("\nComponents:");
        for (int i = 0; i < comp.length; i++) {
            System.out.println("vertex " + i + " → comp " + comp[i]);
        }

        Edge replacement = Prim.findReplacement(g, comp, removed);

        System.out.println("\nReplacement edge: " + replacement);

        System.out.println("\nUpdated MST:");
        mst.remove(removed);
        mst.add(replacement);
        mst.forEach(System.out::println);
    }
}
