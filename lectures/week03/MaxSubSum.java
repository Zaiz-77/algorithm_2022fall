package com.algorithm.lectures.week03;

import java.util.*;

public class MaxSubSum {
    /**
     * Return the max sum of subarray of the array given
     *
     * @param a the array
     * @return the max sum
     */
    public int maxSum(int[] a) {
        int res = a[0], now = 0;
        for (int x : a) {
            now = Math.max(x, now + x);
            res = Math.max(res, now);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, -4, -9, 1, 2};
        MaxSubSum solve = new MaxSubSum();
        System.out.println(solve.maxSum(a));
    }
}
