package top.sephy.leetcode.p704;

public class Solution {

    public int search(int[] nums, int target) {
        return doSearch(nums, target, 0, nums.length - 1);
    }

    int doSearch(int[] nums, int target, int low, int height) {
        if (low > height) {
            return -1;
        }
        int midIdx = (low + height) / 2;
        int midValue = nums[midIdx];
        if (midValue == target) {
            return midIdx;
        }
        if (midValue > target) {
            return doSearch(nums, target, low, midIdx - 1);
        } else if (midValue < target) {
            return doSearch(nums, target, midIdx + 1, height);
        }
        return -1;
    }
}
