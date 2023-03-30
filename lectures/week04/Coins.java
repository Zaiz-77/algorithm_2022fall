package com.algorithm.lectures.week04;

import java.util.*;

public class Coins {
    /**
     * Returns the min count of changes
     *
     * @param coins the coins given
     * @param all   the money need to changed
     * @return the min count of each coin in a increasing order
     */
    public int[] wayOfChange(int[] coins, int all) {
        int n = coins.length;
        Arrays.sort(coins);
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (all < coins[i]) continue;
            res[i] = all / coins[i];
            all -= res[i] * coins[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        Coins solve = new Coins();
        System.out.println(Arrays.toString(solve.wayOfChange(coins, 205)));
    }
}
