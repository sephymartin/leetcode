package top.sephy.leetcode.p4;

public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums3 = new int[nums1.length + nums2.length];
        int k = 0;
        NumSeekHelper helper = new NumSeekHelper(nums1, nums2);
        while (k < nums3.length) {
            nums3[k++] = helper.getMin();
            if (k > 1 && nums3[k - 2] > nums3[k - 1]) {
                swap(nums3, k - 2, k - 1);
            }
        }

        if (nums3.length % 2 == 0) {
            return (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0d;
        } else {
            return nums3[nums3.length / 2] / 1.0d;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static class NumSeekHelper {

        int i = 0;
        int j = 0;
        int[] nums1;
        int[] nums2;

        public NumSeekHelper(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
        }

        public int getMin() {
            if (i < nums1.length) {
                if (j < nums2.length) {
                    if (nums1[i] <= nums2[j]) {
                        return nums1[i++];
                    } else {
                        return nums2[j++];
                    }
                } else { // nums2 end
                    return nums1[i++];
                }
            } else { // nums1 end
                return nums2[j++];
            }
        }

    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        findMedianSortedArrays(nums1, nums2);
    }
}