package com.algorithm.lectures.week04;

import java.util.*;

public class Huffman {
    static class Node {
        int cnt;
        char c;
        Node left, right;

        public Node() {
        }

        public Node(int cnt, char c, Node left, Node right) {
            this.cnt = cnt;
            this.c = c;
            this.left = left;
            this.right = right;
        }

        public Node(int cnt, Node left, Node right) {
            this.cnt = cnt;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Returns the mapping between the code and the character
     *
     * @param cs  the characters
     * @param cnt the frequency of each character
     * @return the mapping between the code and the character
     */
    public Map<Character, String> huffman(char[] cs, int[] cnt) {
        Map<Character, String> res = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.cnt));
        int n = cs.length;
        for (int i = 0; i < n; i++) q.add(new Node(cnt[i], cs[i], null, null));

        Node root = new Node();
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                res.put(cs[0], "0");
                break;
            } else {
                Node l = q.poll(), r = q.poll();
                Node fa = new Node(l.cnt + r.cnt, l, r);
                q.add(fa);
                root = fa;
            }
        }

        dfs(root, res, new StringBuilder());
        return res;
    }

    private void dfs(Node root, Map<Character, String> res, StringBuilder now) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.put(root.c, now.toString());
            return;
        }
        if (root.left != null) {
            now.append("0");
            dfs(root.left, res, now);
            now.deleteCharAt(now.length() - 1);
        }
        if (root.right != null) {
            now.append("1");
            dfs(root.right, res, now);
            now.deleteCharAt(now.length() - 1);
        }
    }

    public static void main(String[] args) {
        char[] cs = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] cnt = {45, 13, 12, 16, 9, 5};
        Huffman solve = new Huffman();
        System.out.println(solve.huffman(cs, cnt));
    }
}
