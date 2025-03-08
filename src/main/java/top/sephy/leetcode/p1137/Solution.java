package top.sephy.leetcode.p1137;

public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        fibArray[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2] + fibArray[i - 3];
        }
        return fibArray[n];
    }

    public static void main(String[] args) {
        new Solution().tribonacci(4);
    }
}