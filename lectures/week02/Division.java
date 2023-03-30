package com.algorithm.lectures.week02;

import java.util.*;

public class Division {
    /**
     * Returns all of the methods of dividing the number n with the numbers less than n
     *
     * @param n the number to be divided
     * @return the number of all the methods
     */
    public long division(int n) {
        return partition(n, n);
    }

    private long partition(int n, int m) {
        if (n < 0) return 0;
        if (m == 1) return 1;
        return partition(n, m - 1) + partition(n - m, m);
    }

    public static void main(String[] args) {
        Division division = new Division();
        System.out.println(division.division(6));
    }
}
