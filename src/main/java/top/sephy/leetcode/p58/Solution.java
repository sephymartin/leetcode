package top.sephy.leetcode.p58;

public class Solution {

    public int lengthOfLastWord(String s) {
        char space = ' ';
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == space) {
                if (length > 0) {
                    break;
                }
            } else {
                length++;
            }
        }

        return length;
    }
}
