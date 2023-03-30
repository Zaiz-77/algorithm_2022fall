package com.algorithm.lectures.week01;

import java.util.*;

public class Sort {
    /**
     * sort the arr with bubble sort
     *
     * @param a   the arr to be sorted
     * @param <T> para type
     */
    // max:O(n^2)  min:O(n) avg:O(n^2)
    public <T extends Comparable<T>> void bubbleSort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) swap(a, j, j + 1);
            }
        }
    }

    /**
     * sort the arr with selection sort
     *
     * @param a   the arr to be sorted
     * @param <T> para type
     *            max:O(n^2)  min:O(n^2) avg:O(n^2)
     */
    public <T extends Comparable<T>> void selectSort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            T min = a[i];
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(min) < 0) {
                    min = a[j];
                    idx = j;
                }
            }
            if (!a[i].equals(min)) swap(a, i, idx);
        }
    }

    /**
     * sort the arr with insertion sort
     *
     * @param a   the arr to be sorted
     * @param <T> para type
     *            max:O(n^2)  min:O(n) avg:O(n^2)
     */
    public <T extends Comparable<T>> void insertSort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int idx = i - 1;
            while (idx >= 0 && a[i].compareTo(a[idx]) < 0) {
                a[idx + 1] = a[idx];
                idx--;
            }
            a[idx + 1] = a[i];
        }
    }

    private <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        Random rand = new Random();
        Integer[] ints = new Integer[500];
        for (int i = 0; i < 500; i++) ints[i] = rand.nextInt(750) + 100;
        // sort.bubbleSort(ints);
        // sort.selectSort(ints);
        sort.insertSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
