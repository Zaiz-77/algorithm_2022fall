package com.algorithm.lectures.week03;

import java.util.*;

public class LCS {
    private final StringBuilder res = new StringBuilder();

    /**
     * Get the LCS from (i, j) to (0, 0)
     *
     * @param p the position array
     * @param i the x-axis pos
     * @param j the y-axis pos
     * @param s result
     */
    private void dfs(int[][] p, int i, int j, String s) {
        if (i == 0 && j == 0) {
            System.out.println(res.reverse());
            return;
        }
        if (p[i][j] == 0) {
            res.append(s.charAt(i - 1));
            dfs(p, i - 1, j - 1, s);
        } else if (p[i][j] == -1) {
            dfs(p, i - 1, j, s);
        } else dfs(p, i, j - 1, s);
    }

    /**
     * Calc the length of LCS of s1 and s2
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return the length of LCS of s1 and s2
     */
    public int longestSubSequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] p = new int[m + 1][n + 1];
        int[][] f = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    p[i][j] = 0;
                } else if (f[i - 1][j] >= f[i][j - 1]) {
                    f[i][j] = f[i - 1][j];
                    p[i][j] = -1;
                } else if (f[i][j - 1] >= f[i - 1][j]) {
                    f[i][j] = f[i][j - 1];
                    p[i][j] = 1;
                }
            }
        }
        dfs(p, m, n, s1);
        return f[m][n];
    }

    public static void main(String[] args) {
        String s1 = "apple", s2 = "application";
        LCS solve = new LCS();
        System.out.println(solve.longestSubSequence(s1, s2));
    }
}
