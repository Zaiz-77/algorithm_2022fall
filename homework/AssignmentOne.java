package com.algorithm.homework;

import java.util.*;

public class AssignmentOne {
    public int[] search(int[] a, int x) {
        int l = 0, r = a.length;
        int[] res = new int[2];
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (a[mid] == x) {
                res[0] = res[1] = mid;
                return res;
            } else if (a[mid] > x) r = mid - 1;
            else l = mid + 1;
            res[0] = r;
            res[1] = l;
        }
        return res;
    }

    public void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        sort(a, 0, p);
        sort(a, p + 1, r);
    }

    private int partition(int[] a, int l, int r) {
        int now = a[l];
        while (l < r) {
            while (l < r && a[r] <= now) r--;
            a[l] = a[r];
            while (l < r && a[l] >= now) l++;
            a[r] = a[l];
        }
        a[l] = now;
        return l;
    }

    public int[] findMode(int[] a) {
        int[] res = new int[2];
        int[] cnt = new int[100005];
        for (int x : a) cnt[x]++;
        for (int x : cnt) {
            if (cnt[x] > res[1]) {
                res[1] = cnt[x];
                res[0] = x;
            }
        }
        return res;
    }

    public int solveRecursion(int n) {
        int res = 1;
        if (n == 1) return 1;
        for (int i = 1; i <= n / 2; i++) res += solveRecursion(i);
        return res;
    }

    private int[] f = new int[1005];

    public int solveIteration(int n) {
        if (n == 1) return 1;
        int res = 1;
        f[1] = 1;
        if (f[n] > 0) return f[n];
        for (int i = 1; i <= n / 2; i++) {
            f[i] = solveIteration(i);
            res += f[i];
        }
        return res;
    }

    public static void main(String[] args) {
        AssignmentOne solve = new AssignmentOne();
        int[] a = {1, 5, 9, 11, 17, 21, 23, 25, 29, 31, 45, 59};
        System.out.println(Arrays.toString(a));
        System.out.println("BinarySearch:" + Arrays.toString(solve.search(a, 23)));
        System.out.println("BinarySearch:" + Arrays.toString(solve.search(a, 27)));
        System.out.println();

        int[] b = {45, 78, 9, -4, 19, -99, 49, -999, 9119, 94, 1, 9, 594, 9, 1, 9, 592, 3, 0, 9, 0};
        System.out.println(Arrays.toString(b));
        System.out.println("Before QuickSort:" + Arrays.toString(b));
        solve.sort(b, 0, b.length - 1);
        System.out.println("After QuickSort:" + Arrays.toString(b));
        System.out.println();

        int[] c = {1, 1, 1, 1, 1, 1, 12, 6, 9, 9, 9, 9, 9, 9, 9, 45, 9, 9};
        System.out.println(Arrays.toString(c));
        System.out.println("FindMode:" + Arrays.toString(solve.findMode(c)));
        System.out.println();

        System.out.printf("set(%d) = %d\n", 15, solve.solveRecursion(15));
        System.out.printf("set(%d) = %d", 15, solve.solveIteration(15));
    }
}
