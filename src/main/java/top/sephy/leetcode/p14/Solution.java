package top.sephy.leetcode.p14;

public class Solution {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        String baseStr = strs[0];
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // 字符串长度判断，防止数组越界
                if (i <= strs[j].length() - 1) {
                    // 如果不相等，直接返回当前最大前缀
                   if (c != strs[j].charAt(i)) {
                       return prefix.toString();
                   }
                } else {
                    // 字符串长度不够直接返回当前最大前缀
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
