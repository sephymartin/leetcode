package top.sephy.leetcode.p746;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int[] cost2 = new int[cost.length + 1];
        System.arraycopy(cost, 0, cost2, 0, cost.length);
        cost2[cost.length] = 0;

        /**
         * 要爬当前的台阶，肯定需要加上当前的 cost[i]
         * dp[i] = cost[i] + min(dp[i- 1], dp[i - 2])
         */

        int[] minCost = new int[cost2.length];
        minCost[0] = cost2[0];
        minCost[1] = cost2[1];
        for (int i = 2; i < cost2.length; i++) {
            minCost[i] = cost2[i] + Math.min(minCost[i - 1], minCost[i - 2]);
        }

        /**
         * dp[i] = 一个是从第 i-2 层上直接跳上来，一个是从第 i-1 层上跳上来
         * dp[i] = min(dp[i- 2] + cost[i - 2], dp[i - 1] + cost[i - 1])
         */

        return minCost[cost.length];
    }
}
