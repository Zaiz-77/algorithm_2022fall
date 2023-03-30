package com.algorithm.lectures.week02;

import java.util.*;

public class LinearSelect {
    /**
     * Find the kth smallest element in the given array
     *
     * @param a the array
     * @param k the order
     * @return the pos of the number
     * T(n) = T(n - k) + O(n) max:O(n^2) avg:O(n)
     */
    public int randomSelect(int[] a, int k) {
        int n = a.length;
        return randomSelect(a, k, 0, n - 1);
    }

    private int randomSelect(int[] a, int k, int l, int r) {
        int p = partition(a, l, r, a[l]);
        int len = p - l + 1;
        if (len == k) return a[p];
        return k < len ? randomSelect(a, k, l, p - 1) : randomSelect(a, k - len, p + 1, r);
    }

    private int partition(int[] a, int l, int r, int now) {
        while (l < r) {
            while (l < r && a[r] >= now) r--;
            a[l] = a[r];
            while (l < r && a[l] <= now) l++;
            a[r] = a[l];
        }
        a[l] = now;
        return l;
    }

    // TODO: solve the bug in this function
    public int linearSelect(int[] a, int k) {
        return linearSelect(a, k, 0, a.length - 1);
    }

    private int linearSelect(int[] a, int k, int l, int r) {
        if (r - l + 1 < 75) {
            Arrays.sort(a, l, r + 1);
            return a[l + k - 1];
        }
        for (int i = 0; i <= (r - l - 4) / 5; i++) {
            int mid = findMid(a, l + 5 * i, l + 5 * i + 4);
            swap(a, l + i, mid);
        }
        int mMid = linearSelect(a, (r - l + 6) / 10, l, l + (r - l - 4) / 5);
        int pos = partition(a, l, r, mMid);
        int len = pos - l + 1;
        return k <= len ? linearSelect(a, k, l, pos) : linearSelect(a, k - len, pos + 1, r);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private int findMid(int[] a, int l, int r) {
        int[] b = new int[r - l + 1];
        System.arraycopy(a, l, b, 0, r - l + 1);
        Arrays.sort(b);
        for (int i = l; i <= r; i++) {
            if (a[i] == b[(r - l + 1) / 2]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        LinearSelect select = new LinearSelect();

        int[] a = new int[100], b = new int[100];
        for (int i = 0; i < 100; ) a[i++] = rand.nextInt();
        System.arraycopy(a, 0, b, 0, 100);

        Arrays.sort(b);
        for (int i = 0; i < 50; i++) {
            int p = rand.nextInt(a.length) + 1;
            System.out.println(select.linearSelect(a, p) == select.randomSelect(a, p));
        }
    }
}
