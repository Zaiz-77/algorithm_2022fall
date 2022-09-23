package com.algorithm.lectures.week03;

import java.util.*;

public class LongestSubSequence {
    public int longestSubSequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) f[i][0] = 0;
        for (int j = 0; j < n; j++) f[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) f[i][j] = f[i - 1][j - 1] + 1;
                else f[i][j] = Math.max(f[i][j - 1], f[i - 1][j]);
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        String s1 = "apple", s2 = "application";
        LongestSubSequence solve = new LongestSubSequence();
        System.out.println(solve.longestSubSequence(s1, s2));
    }
}
