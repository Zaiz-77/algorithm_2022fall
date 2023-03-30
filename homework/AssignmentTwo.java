package com.algorithm.homework;

import java.util.*;

public class AssignmentTwo {
    public int triangle(int[][] a) {
        int n = a.length;
        int[][] f = new int[n][n];
        f[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + a[i][0];
            f[i][i] = f[i - 1][i - 1] + a[i][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + a[i][j];
            }
        }
        int res = 0;
        for (int x : f[n - 1]) res = Math.max(res, x);
        return res;
    }

    public int lease(int[][] a) {
        int n = a.length;
        int[][] f = new int[n][n];
        System.arraycopy(a, 0, f, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                }
            }
        }
        return f[0][n - 1];
    }

    public int minHouse(int[] st, int[] ed) {
        int res = 0, j = 1;
        Arrays.sort(st);
        Arrays.sort(ed);
        for (int i = 1; i < st.length; i++) {
            if (st[i] < ed[j]) res++;
            else j++;
        }
        return res;
    }

    public int minAdd(int n, int[] a) {
        int res = -1, rem = n;
        for (int x : a) {
            if (x > n) {
                res = -1;
                break;
            } else if (rem >= x) rem -= x;
            else {
                res++;
                rem = n - x;
            }
        }
        return res == -1 ? -1 : res + 1;
    }

    public int minDelete(int x, int k) {
        // 用数字小的数组成的数，肯定比数字大的小，而数字小的数，需要按照下标排列
        char[] cs = String.valueOf(x).toCharArray();
        int n = cs.length, diff = n - k, res = 0;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = i;
            a[i][1] = cs[i] - '0';
        }
        Arrays.sort(a, Comparator.comparingInt(xx -> xx[1]));
        Arrays.sort(a, 0, diff, Comparator.comparingInt(xx -> xx[0]));
        for (int i = 0; i < diff; i++) res = (res * 10) + a[i][1];
        return res;
    }

    public static void main(String[] args) {
        AssignmentTwo solve = new AssignmentTwo();
        System.out.println("max triangle");
        int[][] triangle = {
                {7, 0, 0, 0, 0},
                {3, 8, 0, 0, 0},
                {8, 1, 0, 0, 0},
                {2, 7, 4, 4, 0},
                {4, 5, 2, 6, 5}
        };
        System.out.println(solve.triangle(triangle));
        System.out.println("------------------------------");

        System.out.println("min lease");
        int[][] cost = {
                {0, 5, 15},
                {0, 0, 7},
                {0, 0, 0}
        };
        System.out.println(solve.lease(cost));
        System.out.println("------------------------------");

        System.out.println("min house");
        int[] st = {1, 12, 25, 36, 27}, ed = {23, 28, 35, 50, 80};
        System.out.println(solve.minHouse(st, ed));
        System.out.println("------------------------------");

        System.out.println("min add");
        int[] a = {1, 2, 3, 4, 5, 1, 6, 6};
        System.out.println(solve.minAdd(7, a));
        System.out.println("------------------------------");

        System.out.println("min delete");
        System.out.println(solve.minDelete(184573, 4));
        System.out.println("------------------------------");
    }
}
