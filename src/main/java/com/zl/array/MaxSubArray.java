package com.zl.array;

//
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
public class MaxSubArray {

    public static void main(String[] args) {

    }

    /**
     * 使用贪心算法
     *  考虑 每一次叠加, 如果加的结果是负的,就要舍去,取下一个正数,重新curSum叠加
     *  每一次贪心,贪到和为负数,知道下一个正数出现,重新贪心
     *  curSum + nums[i] 与 nums[i] 取最大值
     *  可以判断出curSum的结果是否是大于0的 与 nums[i]的结果是否是大于0的
     *  如果 curSum < 0, 直到nums[i] > 0, 更新curSum = nums[i]
     *  使用maxSum记录curSum出现的最大值.
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 使用动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //默认最大值取0索引位置的数
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //使用nums[i - 1]存储状态值, 如果之前的和是负数,当前状态的最大值为自己nums[i]
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(maxSum, nums[i]); // 此时 nums[i] 记录的是最新状态的最大值;
        }
        return maxSum;
    }

    /**
     * 使用分治法
     *  思路: 1.定义基本情况
     *        2.将问题拆分为子问题, 递归解决
     *        3.合并子问题的解得到原始问题的解
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return 0;
    }
}
