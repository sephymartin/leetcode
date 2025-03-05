package top.sephy.leetcode.p27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                result[j++] = nums[i];
            }
        }
        System.arraycopy(result, 0, new int[j], 0, j);
        return j;
    }
}
