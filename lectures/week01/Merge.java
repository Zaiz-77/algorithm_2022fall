package com.algorithm.lectures.week01;

import java.util.*;

public class Merge {
    /**
     * merge two ordered arr into a new one
     *
     * @param a the first arr
     * @param b the second arr
     * @return the result
     * max:O(n) min:O(n) avg:O(n)
     */
    public int[] merge(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] res = new int[n];
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < a.length && p2 < b.length) res[p++] = a[p1] < b[p2] ? a[p1++] : b[p2++];
        while (p1 < a.length) res[p++] = a[p1++];
        while (p2 < b.length) res[p++] = b[p2++];
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 15, 46}, b = {12, 47, 98, 451};
        Merge merge = new Merge();
        System.out.println(Arrays.toString(merge.merge(a, b)));
    }
}
