package com.algorithm.lectures.week02;

import java.util.*;

public class Fibonacci {
    /**
     * Return the nth number in fibonacci sequence
     *
     * @param n the pos of the number
     * @return the result
     * T(n) = T(n - 1) + T(n - 2) q > 1 O(2^n)
     */
    public long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibonacci(10));
    }
}
