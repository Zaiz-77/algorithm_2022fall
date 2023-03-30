package com.algorithm.lectures.week03;

import java.util.*;

public class Matrix {
    private final StringBuilder res = new StringBuilder();

    /**
     * Get the correct way to add parentheses from l to r
     *
     * @param p the position array
     * @param l the left end
     * @param r the right end
     */
    private void dfs(int[][] p, int l, int r) {
        if (l == r) {
            res.append("A").append(l + 1);
            return;
        }
        res.append("(");
        dfs(p, l, p[l][r]);
        res.append("*");
        dfs(p, p[l][r] + 1, r);
        res.append(")");
    }

    /**
     * Calc the min cost of add parentheses
     *
     * @param a an array that represents the rows and columns of a matrix
     * @return the min cost
     */
    public long minCount(int[][] a) {
        int n = a.length;
        int[][] p = new int[n][n];
        long[][] f = new long[n][n];
        for (int i = 0; i < n; i++) f[i][i] = 0;

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                f[l][r] = f[l + 1][r] + a[l][0] * a[l][1] * a[r][1];
                p[l][r] = l;
                for (int k = l; k <= r && k + 1 < n; k++) {
                    long nxt = f[l][k] + f[k + 1][r] + a[l][0] * a[k][1] * a[r][1];
                    if (nxt < f[l][r]) {
                        f[l][r] = nxt;
                        p[l][r] = k;
                    }
                }
            }
        }
        dfs(p, 0, n - 1);
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        Matrix solve = new Matrix();
        int[][] a = {
                {20, 30},
                {30, 25},
                {25, 17},
                {17, 23},
                {23, 14},
        };
        System.out.println(solve.minCount(a));
        System.out.println(solve.res);
    }
}
