package top.sephy.leetcode.p29;

public class Solution {
    public int divide(int dividend, int divisor) {

        // 符号不同
        boolean negetive = (dividend ^ divisor) < 0;

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        long absDivisor = Math.abs((long)divisor);
        long absDividend = Math.abs((long)dividend);
        int val = 0;
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multi = 1;
            // tempDivisor << 1 双倍
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multi <<= 1;
            }
            absDividend -= tempDivisor;
            val += multi;
        }

        return negetive ? -val : val;
    }

    public static void main(String[] args) {
        new Solution().divide(1, 1);
    }
}
