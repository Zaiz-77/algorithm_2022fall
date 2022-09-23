package com.algorithm.lectures.week03;

import java.util.*;

public class Lease {
    public long minCost(int[][] a) {
        int n = a.length;
        long[][] f = new long[n][n];

        // 1 2 3 4 5
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) f[i][j] = 0;
                else f[i][j] = a[i][i + 1] + f[i + 1][j];
                for (int k = i; k <= j && k + 1 < n; k++) {
                    f[i][j] = Math.min(f[i][j], Math.min(a[i][j], f[i][k] + f[k][j]));
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 5, 15, 30},
                {0, 0, 7, 16},
                {0, 0, 0, 20},
                {0, 0, 0, 0}
        };
        Lease solve = new Lease();
        System.out.println(solve.minCost(a));
    }
}
