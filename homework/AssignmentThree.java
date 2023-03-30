package com.algorithm.homework;

import java.util.*;

public class AssignmentThree {
    int loadRes; // in load function

    private void dfs(int[] a, int c, int cc, int cw, int i) {
        int n = a.length;
        if (c < 0) return;
        loadRes = Math.max(loadRes, cw);

        for (int j = i; j < n; j++) dfs(a, c - a[j], cc + a[j], cw + a[j], j + 1);
    }

    public int load(int[] a, int c) {
        this.loadRes = 0;
        dfs(a, c, 0, 0, 0);
        return this.loadRes;
    }

    public static void main(String[] args) {
        AssignmentThree solve = new AssignmentThree();
        System.out.println("Load:");
        int[] a1 = {7, 2, 6, 5, 4};
        System.out.println(solve.load(a1, 10));
        System.out.println("=================================");
    }
}
