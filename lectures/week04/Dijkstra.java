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
        int[] dis = new int[n];
        boolean[] vi = new boolean[n];
        Arrays.fill(dis, M);
        dis[src] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.len));
        q.offer(new Node(src, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int i = now.no;
            if (vi[i]) continue;
            vi[i] = true;
            for (int j = 0; j < n; j++) {
                if (es[i][j] > 0) {
                    Node nxt = new Node(j, dis[i] + es[i][j]);
                    if (nxt.len < dis[j]) {
                        dis[j] = nxt.len;
                        q.offer(nxt);
                    }
                }
            }
        }

        return dis[dst];
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
