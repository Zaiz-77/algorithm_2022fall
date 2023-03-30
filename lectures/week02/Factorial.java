package com.algorithm.lectures.week02;

import java.util.*;

public class Factorial {
    /**
     * Returns the factorial of n
     *
     * @param n the number
     * @return the result
     * O(n!)
     */
    public long factorial(int n) {
        if (n == 1 || n == 0) return 1L;
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.factorial(10));
    }
}
