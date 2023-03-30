package com.algorithm.lectures.week05;

import java.util.*;

public class Subset {
    public List<List<Integer>> solve(int[] a) {
        List<Integer> now = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, a, now, res);
        return res;
    }

    private void dfs(int st, int[] a, List<Integer> now, List<List<Integer>> res) {
        res.add(new ArrayList<>(now));
        if (st >= a.length) return;
        for (int i = st; i < a.length; i++) {
            now.add(a[i]);
            dfs(i + 1, a, now, res);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        Subset solve = new Subset();
        System.out.println(solve.solve(a));
    }
}
