package com.algorithm.lectures.week03;

import java.util.*;

public class Matrix {
    private final StringBuilder res = new StringBuilder();

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
                {30, 35},
                {35, 15},
                {15, 5},
                {5, 10},
                {10, 20},
                {20, 25}
        };
        System.out.println(solve.minCount(a));
        System.out.println(solve.res);
    }
}
