package com.algorithm.lectures.week06;

import java.util.*;

public class BranchBound {
    static class State {
        int i, cv, rc;

        public State(int i, int cv, int rc) {
            this.i = i;
            this.cv = cv;
            this.rc = rc;
        }
    }

    public int knapsack(int n, int[] w, int[] v, int c) {
        int res = 0;
        // 前缀和，方便计算一整段的价值和
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + v[i - 1];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, 0, c));
        while (!q.isEmpty()) {
            State now = q.poll();
            // 本状态接下来要对下标为 i 的物品进行决策，决策前更新最大值，（注意，当前状态仍然是合理的）
            int i = now.i, cv = now.cv, rc = now.rc;
            System.out.println(rc + " " + cv);
            // 如果要决策的下标越界了，说明当前已经把最后一层树决策完成了，退出
            if (i >= n) break;
            // 否则计算不选该物品之后的所有价值 和 选择该物品之后的所有价值
            int rp0 = s[n] - s[i + 1], rp1 = s[n] - s[i];
            // 对于选的，体积不能超，上界要趋向最优
            if (rc >= w[i] && rp1 + cv > res) {
                q.offer(new State(i + 1, cv + v[i], rc - w[i]));
                res = Math.max(res, cv + v[i]);
            }
            // 对于不选的，只要求上界趋向最优
            if (rp0 + cv > res) {
                q.offer(new State(i + 1, cv, rc));
                res = Math.max(res, cv);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BranchBound solve = new BranchBound();
        int[] w = {3, 5, 2, 1};
        int[] v = {9, 10, 7, 4};
        System.out.println(solve.knapsack(4, w, v, 7));
    }
}
