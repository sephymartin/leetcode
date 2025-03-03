package top.sephy.leetcode.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    Set<String> numStrSet = new HashSet<>();
    List<List<Integer>> lists = new ArrayList<>();

    void addTriple(int a, int b, int c) {
        int[] temp = new int[] {a, b, c};
        Arrays.sort(temp);
        String numStr = Arrays.toString(temp);
        if (!numStrSet.contains(numStr)) {
            // 添加结果
            lists.add(Arrays.asList(a, b, c));
            numStrSet.add(numStr);
            System.out.println(numStr);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int zeroIdxFrom = -1;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIdxFrom == -1) {
                    zeroIdxFrom = i;
                }
                zeroCount++;
            }
        }

        if (zeroCount >= 3) {
            addTriple(0, 0, 0);
        }

        int i = 0;
        while (i < nums.length - 2) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    addTriple(nums[i], nums[left], nums[right]);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;
        }

        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // List<List<Integer>> lists = solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        List<List<Integer>> lists = solution.threeSum(new int[] {-2, 0, 1, 1, 2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
