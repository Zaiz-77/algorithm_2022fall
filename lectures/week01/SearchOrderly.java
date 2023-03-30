package com.algorithm.lectures.week01;

import java.util.*;

public class SearchOrderly {
    /**
     * Search t in arr
     *
     * @param arr    the array to be searched
     * @param target the target element
     * @param <T>    para type
     * @return idx of the target if find else -1
     * max:T(n) min:T(1)
     * avg:∑(pi * ti) 假设成功概率是p，而每一个位置成功的概率相等都是 p / n
     */
    public <T> int search(T[] arr, T target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchOrderly solve = new SearchOrderly();
        Integer[] ints = {1, 5, 9, 1, 9, 4, 9, 7, 8, 91, 91, 9, 4, 19, 145, 959, 4};
        String[] cs = {"apple", "good", "fine", "six"};
        System.out.println(solve.search(ints, 145));
        System.out.println(solve.search(cs, "nice"));
    }
}
