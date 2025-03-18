package top.sephy.leetcode.p28;

public class Solution {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while(j<needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("a", "a"));
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
        System.out.println(new Solution().strStr("leetcode", "leeto"));
    }
}
