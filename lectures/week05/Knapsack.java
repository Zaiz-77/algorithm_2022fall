package com.algorithm.lectures.week05;

public class Knapsack {
    static int res = 0;

    private void dfs(int st, int w, int v, int V, int[] ws, int[] vs) {
        if (st == ws.length) {
            if (w <= V && v > res) {
                res = v;
            }
            return;
        }
        dfs(st + 1, w, v, V, ws, vs);
        dfs(st + 1, w + ws[st], v + vs[st], V, ws, vs);
    }

    /**
     * Solve 01Knapsack problem with dfs
     *
     * @param V  the max capacity
     * @param ws the weights
     * @param vs the values
     * @return the max value can hold
     */
    public int solve(int V, int[] ws, int[] vs) {
        dfs(0, 0, 0, V, ws, vs);
        return res;
    }


    public static void main(String[] args) {
        int[] ws = {2, 3, 4, 5}, vs = {3, 5, 5, 7};
        Knapsack solve = new Knapsack();
        System.out.println(solve.solve(9, ws, vs));
    }
}
