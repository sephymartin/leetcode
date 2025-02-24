package top.sephy.leetcode.p13;

public class Solution {

    static int strToInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int num = 0;
        char[] charArray = s.toCharArray();
        // 从右到左遍历
        for (int i = charArray.length - 1; i >= 0; i--) {
            int cur = strToInt(charArray[i]);
            if (i < charArray.length - 1) {
                // 如果当前字符比前一个字符小，则减去当前字符，例如 IV = 5 - 1
                int pre = strToInt(charArray[i + 1]);
                if (cur < pre) {
                    num -= cur;
                } else {
                    num += cur;
                }
            } else {
                num += cur;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
