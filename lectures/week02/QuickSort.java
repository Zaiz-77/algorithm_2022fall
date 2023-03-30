package com.algorithm.lectures.week02;

import java.util.*;

public class QuickSort {
    /**
     * sort the arr with quicksort
     *
     * @param a the arr to be sorted
     */
    // T(n) = 2 * T(n / 2) + O(n) O(n lng)  max: O(n) (每次都是 1 与 n - 1 两部分，而不是中间位置)
    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    private int partition(int[] a, int l, int r) {
        int now = a[l];
        while (l < r) {
            while (l < r && a[r] >= now) r--;
            a[l] = a[r];
            while (l < r && a[l] <= now) l++;
            a[r] = a[l];
        }
        a[l] = now;
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 9, 1, 9, 4, 9, 7, 8, 91, 91, 9, 4, 19, 145, 959, 4};
        QuickSort sort = new QuickSort();
        sort.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
