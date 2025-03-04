package top.sephy.leetcode.p3402;

public class Solution {

    public int minimumOperations(int[][] grid) {
        int ops = 0;
        for (int col = 0; col < grid[0].length; col++) {
            int prev = 0;
            for (int row = 1; row < grid.length; row++) {
                if (row == 1) {
                    prev = grid[row - 1][col];
                }
                int current = grid[row][col];
                if (prev >= current) {
                    int expect = prev + 1;
                    ops += expect - current;
                    prev = expect;
                } else {
                    prev = current;
                }

            }
        }

        return ops;
    }

    public static void main(String[] args) {
        new Solution()
            .minimumOperations(new int[][] {new int[] {3, 2}, new int[] {1, 3}, new int[] {3, 4}, new int[] {0, 1}});
    }
}