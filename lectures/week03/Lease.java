package com.algorithm.lectures.week03;

import java.util.*;

public class Lease {
    private final StringBuilder res = new StringBuilder();

    /**
     * Get the way from l to r
     *
     * @param p the position array
     * @param l start point
     * @param r end point
     */
    private void dfs(int[][] p, int l, int r) {
        res.append(r + 1);
        if (l != r) dfs(p, l, p[l][r]);
    }

    /**
     * Get the min cost from 1 to n
     *
     * @param a the cost board
     * @return the min cost
     */
    public int minCost(int[][] a) {
        int n = a.length;
        int[][] f = new int[n][n], p = new int[n][n];
        System.arraycopy(a, 0, f, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                p[i][j] = i;
                for (int k = i; k <= j; k++) {
                    if (f[i][k] + f[k][j] < f[i][j]) {
                        f[i][j] = f[i][k] + f[k][j];
                        p[i][j] = k;
                    }
                }
            }
        }
        dfs(p, 0, n - 1);
        System.out.println(res.reverse());
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 3, 15, 30},
                {0, 0, 2, 16},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        Lease solve = new Lease();
        System.out.println(solve.minCost(a));
    }
}
