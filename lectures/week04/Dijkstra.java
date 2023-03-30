package com.algorithm.lectures.week04;

import java.util.*;

public class Dijkstra {
    static class Node {
        int no, len;

        public Node() {
        }

        public Node(int no, int len) {
            this.no = no;
            this.len = len;
        }
    }

    /**
     * Returns the min dist from src to dst
     *
     * @param es  the edges between vertexes
     * @param src the start point
     * @param dst the end point
     * @return the min dist
     */
    public int dijkstra(int[][] es, int src, int dst) {
        int n = es.length, M = 1141567918;
        int[] d = new int[n];
        boolean[] vi = new boolean[n];
        Arrays.fill(d, M);
        d[src] = 0;
        vi[src] = true;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.len));
        Node st = new Node(src, 0);
        q.add(st);

        while (!q.isEmpty()) {
            Node now = q.poll();
            int from = now.no, cost = now.len;
            vi[from] = true;
            for (int to = 0; to < n; to++) {
                if (es[from][to] != -1 && !vi[to]) {
                    Node nxt = new Node(to, cost + es[from][to]);
                    if (nxt.len < d[to]) {
                        d[to] = nxt.len;
                        q.add(nxt);
                    }
                }
            }
        }

        return d[dst];
    }

    public static void main(String[] args) {
        int[][] es = {
                {0, 10, -1, 30, 100},
                {-1, 0, 50, -1, -1},
                {-1, -1, 0, -1, 10},
                {-1, -1, 20, 0, 60},
                {-1, -1, -1, -1, 0}
        };
        Dijkstra solve = new Dijkstra();
        System.out.println(solve.dijkstra(es, 1, 4));
    }
}
