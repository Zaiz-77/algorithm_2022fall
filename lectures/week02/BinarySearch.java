package com.algorithm.lectures.week02;

import java.util.*;

public class BinarySearch {
    /**
     * find the idx of target in the arr a
     *
     * @param a      the arr
     * @param target the target
     * @param <T>    para type
     * @return the idx of target if find else -1
     * max: O(lgn) min:O(lgn) avg:O(lgn) T(n) = 2 * T(n / 2)
     */
    public <T extends Comparable<T>> int binarySearch(T[] a, T target) {
        return bs(a, target, 0, a.length - 1);
    }

    public <T extends Comparable<T>> int iterBinarySearch(T[] a, T target) {
        int n = a.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (a[mid].equals(target)) return mid;
            if (a[mid].compareTo(target) > 0) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    private <T extends Comparable<T>> int bs(T[] a, T target, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) >> 1;
        if (a[mid].equals(target)) return mid;
        if (a[mid].compareTo(target) > 0) return bs(a, target, l, mid - 1);
        return bs(a, target, mid + 1, r);
    }

    public static void main(String[] args) {
        Integer[] a = {1, 5, 9, 15, 19, 24, 28, 46, 79};
        BinarySearch search = new BinarySearch();
        System.out.println(search.binarySearch(a, 16));
        System.out.println(search.iterBinarySearch(a, 46));
    }
}
