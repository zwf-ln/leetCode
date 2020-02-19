package com.zl.twoSum;

import java.util.HashMap;
import java.util.Map;

//leetCode第一题 在数组中找出和是目标值的索引
public class TwoSum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return nums;
    }

    /**
     * 在有序数组中查找
     * @return
     */
    public static int[] twoSumBySorted(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        //创建首尾指针
        int begin = 0;
        int end = nums.length - 1;
        //存储结果
        int[] res = new int[2];
        while(begin < end) {
            int sum = nums[begin] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                begin++;
            } else {
                res[0] = begin;
                res[1] = end;
                return res;
            }
        }
        return res;
    }
}
