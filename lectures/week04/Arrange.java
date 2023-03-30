package com.algorithm.lectures.week04;

import java.util.*;

public class Arrange {
    /**
     * Returns the max count of activities can hold
     *
     * @param st start time
     * @param ed end time
     * @return the max count
     */
    public int arrangeActivity(int[] st, int[] ed) {
        int n = st.length, res = 1;
        int[][] acs = new int[n][2];
        for (int i = 0; i < n; i++) {
            acs[i][0] = st[i];
            acs[i][1] = ed[i];
        }
        System.out.println(Arrays.deepToString(acs));
        int lst = acs[0][1];
        for (int i = 1; i < n; i++) {
            if (acs[i][0] > lst) {
                res++;
                lst = acs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] st = {2, 1, 2, 5, 7, 4, 6, 8, 15};
        int[] ed = {5, 5, 8, 10, 11, 13, 15, 22, 24};
        Arrange solve = new Arrange();
        System.out.println(solve.arrangeActivity(st, ed));
    }
}
