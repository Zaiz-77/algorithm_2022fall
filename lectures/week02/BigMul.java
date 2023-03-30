package com.algorithm.lectures.week02;

import java.util.*;

public class BigMul {
    /**
     * Returns the result of a * b(presuming that a has the same bit with b);
     *
     * @param a the first factor
     * @param b the second factor
     * @return the result of a * b
     * 为什么不直接拆分，因为复杂度根本没变，可以考虑用我们已经算出来的数据来替代乘法
     * T(n) = 3 * T(n / 2) + O(n) n^1.59
     */
    public long bigMul(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a > 0 && b > 0) {
            int n = String.valueOf(a).length();
            if (n == 1) return a * b;
            long A = a / pow(10, n / 2), B = a - A * pow(10, n / 2);
            long C = b / pow(10, n / 2), D = b - C * pow(10, n / 2);
            long AC = bigMul(A, C), BD = bigMul(B, D), M = bigMul(A - B, D - C);
            return AC * pow(10, n / 2 * 2) + (M + AC + BD) * pow(10, n / 2) + BD;
        }
        if (a > 0) return -bigMul(a, -b);
        if (b > 0) return -bigMul(-a, b);
        return bigMul(-a, -b);
    }

    private long pow(long a, long b) {
        long res = 1;
        for (; b > 0; b >>= 1, a = (a * a)) if ((b & 1) == 1) res = res * a;
        return res;
    }

    public static void main(String[] args) {
        BigMul bigMul = new BigMul();
        System.out.println(bigMul.bigMul(-12345, 45678));
        System.out.println(-12345 * 45678);
    }
}
