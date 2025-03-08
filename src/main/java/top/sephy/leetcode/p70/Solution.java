package top.sephy.leetcode.p70;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 3; i <= n; i++) {
            ways[i - 1] = ways[i - 2] + ways[i - 3];
        }
        return ways[n - 1];
    }
}