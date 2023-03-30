package com.algorithm.lectures.week04;

import java.util.*;

public class Package {
    /**
     * Returns the max value can get using greedy
     *
     * @param ws the weights
     * @param vs the values
     * @param m  the max capacity
     * @return the max value
     */
    public double knapsack(int[] ws, int[] vs, int m) {
        int n = vs.length;
        double[][] v = new double[n][2];
        for (int i = 0; i < n; i++) {
            v[i][0] = i;
            v[i][1] = 1.0 * vs[i] / ws[i];
        }
        Arrays.sort(v, Comparator.comparingDouble(x -> x[1]));
        double res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (m <= 0) break;
            res += Math.min(ws[(int) v[i][0]], m) * v[i][1];
            m -= Math.min(ws[(int) v[i][0]], m);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ws = {10, 20, 30}, vs = {60, 100, 120};
        Package solve = new Package();
        System.out.println(solve.knapsack(ws, vs, 50));
    }
}
