package top.sephy.leetcode.p66;

public class Solution {

    public int[] plusOne(int[] digits) {
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 0;
        System.arraycopy(digits, 0, tmp, 1, digits.length);
        doPlusOne(tmp, tmp.length - 1);
        if (tmp[0] == 0) {
            int[] result = new int[tmp.length - 1];
            System.arraycopy(tmp, 1, result, 0, result.length);
            return result;
        } else {
            return tmp;
        }
    }

    public void doPlusOne(int[] digits, int i) {
        if (i >= 0 && i < digits.length) {
            int before = digits[i];
            digits[i] = (before + 1) % 10;
            if ((before + 1) >= 10) {
                doPlusOne(digits, i - 1);
            }
        }
    }

}
