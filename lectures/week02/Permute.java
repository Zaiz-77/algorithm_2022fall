package com.algorithm.lectures.week02;

import java.util.*;

public class Permute {
    /**
     * Returns the permutation of the given sequence
     *
     * @param a   the array
     * @param <T> para type
     * @return the result
     * O(n * n!) 找一个上界即可
     */
    public <T> List<List<T>> permute(T[] a) {
        List<List<T>> res = new ArrayList<>();
        List<T> now = new ArrayList<>();
        boolean[] vi = new boolean[a.length];
        dfs(a, now, vi, res);
        return res;
    }

    private <T> void dfs(T[] a, List<T> now, boolean[] vi, List<List<T>> res) {
        if (now.size() == a.length) {
            res.add(new ArrayList<>(now));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!vi[i]) {
                vi[i] = true;
                now.add(a[i]);
                dfs(a, now, vi, res);
                now.remove(now.size() - 1);
                vi[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] cs = {"apple", "banana", "pineapple"};
        Permute permute = new Permute();
        System.out.println(permute.permute(cs));
    }
}
