package top.sephy.leetcode.p86;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        // G(n)=n⊕(n>>1)
        for (int binary = 0; binary < 1 << n; binary++) {
            result.add(binary ^ (binary >> 1));
        }

        return result;
    }
}