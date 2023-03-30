package com.algorithm.lectures.week04;

public class Prim {
    public int myPrim(int[][] es) {
        // 有 O(n ^ 3) 嫌疑
        int res = 0, n = es.length, cnt = 1;
        boolean[] vi = new boolean[n];
        vi[0] = true;
        while (cnt++ < n) {
            int dist = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < n; i++) if (vi[i]) {
                for (int j = 0; j < n; j++) {
                    if (!vi[j] && es[i][j] > 0 && es[i][j] < dist) {
                        dist = es[i][j];
                        idx = j;
                    }
                }
            }
            vi[idx] = true;
            res += dist;
        }
        return res;
    }

    public int prim(int[][] es) {
        // 确实 O(n ^ 2)
        int n = es.length, res = 0;
        int[] t = new int[n];
        System.arraycopy(es[0], 0, t, 0, n);
        for (int i = 1; i < n; i++) {
            int dist = Integer.MAX_VALUE, idx = -1;
            for (int j = 0; j < n; j++) {
                if (t[j] > 0 && t[j] < dist) {
                    dist = t[j];
                    idx = j;
                }
            }
            res += dist;
            t[idx] = 0;
            for (int j = 0; j < n; j++) {
                if (es[idx][j] > 0 && es[idx][j] < t[j] || t[j] == -1) {
                    t[j] = es[idx][j];
                }
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
        Prim solve = new Prim();
        System.out.println(solve.myPrim(es));
        System.out.println(solve.prim(es));
    }
}
