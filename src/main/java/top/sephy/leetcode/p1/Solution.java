package top.sephy.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            Integer index = map.get(b);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(twoSum(nums, 6));
    }
}
