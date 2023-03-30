package com.algorithm.lectures.week01;

import java.util.*;

public class Partition {
    /**
     * divide the arr with idx into two parts and the left lower than a[idx] and the right greater than a[idx]
     *
     * @param a   the arr to be divided
     * @param l   the left
     * @param r   the right
     * @param <T> para type
     * @return the position of the element
     * max:O(n)  min: O(n) avg:O(n)
     */
    public <T extends Comparable<T>> int partition(T[] a, int l, int r) {
        T now = a[l];
        while (l < r) {
            while (l < r && a[r].compareTo(now) >= 0) r--;
            a[l] = a[r];
            while (l < r && a[l].compareTo(now) <= 0) l++;
            a[r] = a[l];
        }
        a[l] = now;
        return l;
    }

    public <T extends Comparable<T>> void quickSort(T[] a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            quickSort(a, l, p);
            quickSort(a, p + 1, r);
        }
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        Integer[] ints = {11, 5, 9, 1, 9, 4, 9, 7, 8, 91, 91, 9, 4, 19, 145, 959, 4};
        System.out.println(partition.partition(ints, 0, ints.length - 1));
        System.out.println(Arrays.toString(ints));

        partition.quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}
