package top.sephy.leetcode.p7;

public class Solution {

    public int reverse(int x) {
        int val = 0;
        int tmp = x;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (tmp != 0) {
            int a = tmp % 10;
            tmp = tmp / 10;
            if (val > max || (val == max && a > 7)) {
                return 0;
            } else if (val < min || (val == min && a < -8)) {
                return 0;
            }
            val = val * 10 + a;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
    }
}
