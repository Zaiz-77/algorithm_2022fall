package com.algorithm.lectures.week05;

import java.util.*;

public class Permute {
    private void dfs(int[] a, boolean[] vi, List<Integer> now, List<List<Integer>> res) {
        if (now.size() == a.length) {
            res.add(new ArrayList<>(now));
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!vi[i]) {
                now.add(a[i]);
                vi[i] = true;
                dfs(a, vi, now, res);
                vi[i] = false;
                now.remove(now.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute (int[] a) {
        List<Integer> now = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vi = new boolean[a.length];
        dfs(a, vi, now, res);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        Permute solve = new Permute();
        System.out.println(solve.permute(a));
    }
}
