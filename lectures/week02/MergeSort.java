package com.algorithm.lectures.week02;

import java.util.*;

public class MergeSort {
    /**
     * sort the arr with mergesort
     *
     * @param a the arr to be sorted
     */
    // T(n) = 2 * T(n / 2) + O(n) max:O(n lgn) min:O(n lgn)
    public void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private void merge(int[] a, int l, int mid, int r) {
        int[] t = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= r) t[p++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        while (p1 <= mid) t[p++] = a[p1++];
        while (p2 <= r) t[p++] = a[p2++];
        System.arraycopy(t, 0, a, l, r - l + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 1, 9, 4, 9, 7, 8, 91, 91, 9, 4, 19, 145, 959, 4};
        MergeSort sort = new MergeSort();
        sort.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
