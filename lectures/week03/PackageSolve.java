package com.algorithm.lectures.week03;

import java.util.*;

public class PackageSolve {
    /**
     * 01 package solved by two-dimensional array
     *
     * @param capacity the max capacity that the bag can hold
     * @param ws       weights array
     * @param vs       values array
     * @return the max earnings
     */
    public int knapsack1(int capacity, int[] ws, int[] vs) {
        int n = ws.length;
        int[][] f = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j >= ws[i - 1]) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - ws[i - 1]] + vs[i - 1]);
                }
            }
        }
        return f[n][capacity];
    }

    /**
     * 01 package solved by one-dimensional array
     *
     * @param capacity the max capacity that the bag can hold
     * @param ws       weights array
     * @param vs       values array
     * @return the max earnings
     */
    public int knapsack2(int capacity, int[] ws, int[] vs) {
        int n = ws.length;
        int[] f = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j >= ws[i - 1]; j--) {
                f[j] = Math.max(f[j], f[j - ws[i - 1]] + vs[i - 1]);
            }
        }
        return f[capacity];
    }

    public static void main(String[] args) {
        int[] ws = {2, 3, 4, 5}, vs = {3, 5, 5, 7};
        PackageSolve solve = new PackageSolve();
        System.out.println(solve.knapsack1(9, ws, vs));
        System.out.println(solve.knapsack2(9, ws, vs));
    }
}
