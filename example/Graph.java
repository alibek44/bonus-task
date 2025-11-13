package org.example;

import java.util.*;

public class Graph {
    private int n;
    private List<List<Edge>> adj;

    public Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int w) {
        Edge e = new Edge(u, v, w);
        adj.get(u).add(e);
        adj.get(v).add(new Edge(v, u, w));
    }

    public List<Edge> getEdges() {
        List<Edge> all = new ArrayList<>();
        for (List<Edge> list : adj) all.addAll(list);
        return all;
    }

    public List<Edge> neighbors(int u) {
        return adj.get(u);
    }

    public int size() {
        return n;
    }
}
