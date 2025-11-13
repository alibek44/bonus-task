package org.example;

public class Edge implements Comparable<Edge> {
    public int u;
    public int v;
    public int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.w, other.w);
    }

    @Override
    public String toString() {
        return u + " - " + v + " : " + w;
    }
}
