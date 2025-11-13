package org.example;

import java.util.*;

public class Prim {

    public static List<Edge> buildMST(Graph g) {
        int n = g.size();
        boolean[] used = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        List<Edge> mst = new ArrayList<>();

        used[0] = true;
        pq.addAll(g.neighbors(0));

        while (!pq.isEmpty() && mst.size() < n - 1) {
            Edge e = pq.poll();
            if (used[e.v]) continue;

            mst.add(e);
            used[e.v] = true;

            for (Edge ne : g.neighbors(e.v)) {
                if (!used[ne.v]) pq.add(ne);
            }
        }

        return mst;
    }

    public static int[] findComponents(int n, List<Edge> mst, Edge removed) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (Edge e : mst) {
            if (e.u == removed.u && e.v == removed.v && e.w == removed.w) continue;
            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        int[] comp = new int[n];
        Arrays.fill(comp, -1);

        int id = 0;
        for (int i = 0; i < n; i++) {
            if (comp[i] == -1) dfs(i, id++, comp, adj);
        }
        return comp;
    }

    private static void dfs(int u, int id, int[] comp, List<List<Integer>> adj) {
        comp[u] = id;
        for (int v : adj.get(u)) {
            if (comp[v] == -1) dfs(v, id, comp, adj);
        }
    }

    public static Edge findReplacement(Graph g, int[] comp, Edge removed) {
        Edge best = null;

        for (Edge e : g.getEdges()) {
            if (comp[e.u] != comp[e.v] && !isSameEdge(e, removed)) {
                if (best == null || e.w < best.w) {
                    best = e;
                }
            }
        }
        return best;
    }

    private static boolean isSameEdge(Edge e1, Edge e2) {
        return (e1.u == e2.u && e1.v == e2.v) || (e1.u == e2.v && e1.v == e2.u);
    }
}
