package com.algorithm.lectures.week04;

import java.util.*;
import java.io.*;

public class Prim {
    public int myPrim(int[][] es) {
        // 有 O(n ^ 3) 嫌疑
        int res = 0, n = es.length, cnt = 1;
        boolean[] vi = new boolean[n];
        vi[0] = true;
        while (cnt++ < n) {
            int dist = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < n; i++)
                if (vi[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!vi[j] && es[i][j] > 0 && es[i][j] < dist) {
                            dist = es[i][j];
                            idx = j;
                        }
                    }
                }
            vi[idx] = true;
            res += dist;
        }
        return res;
    }

    static int max(int... a) {
        int res = a[0];
        for (int i : a) res = Math.max(res, i);
        return res;
    }

    static int min(int... a) {
        int res = a[0];
        for (int i : a) res = Math.min(res, i);
        return res;
    }

    static long modAdd(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    static long modTimes(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    static class Read {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer("");

        String next() {
            while (!stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Pair {
        int fi, se;

        public Pair(int fi, int se) {
            this.fi = fi;
            this.se = se;
        }
    }

    static Read in = new Read();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static final int N = (int) (5e3 + 5);
    static final int M = (int) (6.2e3 + 5);
    static final int MOD = (int) (1e9 + 7);
    static List<List<Pair>> es = new ArrayList<>();
    static int n, m, x, y, z, res;
    static int[] t = new int[N];

    static void prim() {
        Arrays.fill(t, 1, n + 1, Integer.MAX_VALUE);
        for (Pair e : es.get(1)) t[e.fi] = min(t[e.fi], e.se);
        t[1] = 0;
        for (int i = 1; i < n; i++) {
            int dist = Integer.MAX_VALUE, idx = -1;
            for (int j = 1; j <= n; j++) {
                if (t[j] > 0 && dist > t[j]) {
                    dist = t[j];
                    idx = j;
                }
            }
            if (dist == Integer.MAX_VALUE) {
                out.println("orz");
                out.flush();
                return;
            }
            res += dist;
            t[idx] = 0;
            for (Pair e : es.get(idx)) {
                if (t[e.fi] > e.se) t[e.fi] = e.se;
            }
        }
        out.println(res);
        out.flush();
    }

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n + 1; i++) es.add(new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            x = in.nextInt();
            y = in.nextInt();
            z = in.nextInt();
            if (x == y) continue;
            es.get(x).add(new Pair(y, z));
            es.get(y).add(new Pair(x, z));
        }
        prim();
        out.close();
    }
}
