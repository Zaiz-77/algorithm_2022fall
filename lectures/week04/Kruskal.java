package com.algorithm.lectures.week04;

import java.util.*;

public class Kruskal {
    static class Edge {
        int st, ed, w;

        public Edge() {
        }

        public Edge(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }
    }

    private int find(int[] f, int u) {
        if (f[u] == u) return u;
        return f[u] = find(f, f[u]);
    }

    private void merge(int[] f, int u, int v) {
        int f1 = find(f, u), f2 = find(f, v);
        if (f1 == f2) return;
        f[f1] = f2;
    }

    /**
     * Returns the MST of the graph given
     *
     * @param es the edges between vertexes
     * @return the min cost of the MST
     */
    public int kruskal(int[][] es) {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.w));
        int n = es.length, res = 0, cnt = 0;
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = i; // union find init
            for (int j = 0; j < n; j++) if (es[i][j] != -1) q.add(new Edge(i, j, es[i][j]));
        }

        while (!q.isEmpty() && cnt < n) {
            Edge now = q.poll();
            int st = now.st, ed = now.ed;
            if (find(v, st) != find(v, ed)) {
                merge(v, st, ed);
                res += now.w;
                cnt++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] es = {
                {0, 6, 1, 5, -1, -1},
                {6, 0, 5, -1, 3, -1},
                {1, 5, 0, 5, 6, 4},
                {5, -1, 5, 0, -1, 2},
                {-1, 3, 6, -1, 0, 6},
                {-1, -1, 4, 2, 6, 0}
        };
        Kruskal solve = new Kruskal();
        System.out.println(solve.kruskal(es));
    }
}
