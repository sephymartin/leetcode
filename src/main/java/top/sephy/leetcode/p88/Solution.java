package top.sephy.leetcode.p88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] nums = new int[m + n];
        while ((i < m || j < n) && k < m + n) {
            Integer a = null;
            Integer b = null;
            if (i < m) {
                a = nums1[i];
            }
            if (j < n) {
                b = nums2[j];
            }
            if (a == null) {
                nums[k] = b;
                j++;
            } else {
                if (b != null) {
                    if (a <= b) {
                        nums[k] = a;
                        i++;
                    } else {
                        nums[k] = b;
                        j++;
                    }
                } else {
                    nums[k] = a;
                    i++;
                }
            }
            k++;
        }
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        new Solution().merge(new int[] {1, 2, 3}, 3, new int[] {2, 5, 6}, 3);
    }
}
