package com.zl.num;

import java.util.Arrays;

public class FindNumber {
    public static void main(String[] args) {
//        int[] arr = {5,3,5,3,2,4,7,1,9,6,7,5};
//        System.out.println(Arrays.toString(changeNum1(arr, 5)));
//        System.out.println(findMaxDiff(arr));
        int[] arr = {1};
        System.out.println(searchInsert(arr, 1));
    }

    /**
     * 给定一个num,使得大于num的数在数组arr的右边, 小于等于arr的数在arr的左边
     * @param arr
     * @param num
     */
    public static int[] changeNum(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return arr;
        }
        int less = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
               swap(arr, ++less, i);
            }
        }
        return arr;
    }

    /**
     * 小于num的在arr数组的左边, 大于num的在arr数组的右边, 等于num的在arr数组的中间
     * @param arr
     * @param num
     * @return
     */
    public static int[] changeNum1(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return arr;
        }
        int less = -1;
        int more = arr.length;
        for (int i = 0; i < more;) {
            if (arr[i] < num) {
                swap(arr, ++less, i++);
            } else if(arr[i] > num) {
                swap(arr, --more, i);
            } else {
                i++;
            }
        }
        return arr;
    }

    /**
     * 给定一个数组,找出排序后相邻两个数最大差值,要求不使用比较排序
     * 解析, 使用桶排序, 创建一个比原数组长度 + 1的桶
     * 1. 找出原数组中的最大值, 最小值.
     * 2. 将桶在最大值和最小值之间分成len + 1份
     * 3. 遍历原数组,在桶中记录存放在桶中的最大值和最小值
     * 4. 遍历桶, 找出空桶, 最大的差值就在空桶的左右.
     * @param arr
     */
    public static int findMaxDiff(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int max = 0;
        int min = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        int bid = 0;
        boolean[] flags = new boolean[len + 1];
        int[] maxArr = new int[len + 1];
        int[] minArr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            //找出当前元素应该放在桶的位置
            bid = bucket(arr[i], len, max, min);
            maxArr[bid] = flags[bid] ? Math.max(maxArr[bid], arr[i]) : arr[i];
            minArr[bid] = flags[bid] ? Math.min(minArr[bid], arr[i]) : arr[i];
            flags[bid] = true;
        }
        //由于桶的数量比数值大一个, 因此最大差值一定在每个桶的最小值和上一个桶的最大值上
        int res = 0;
        int lastMax = maxArr[0];
        for (int i = 1; i <= len; i++) {
            //如果有值, 取出最小值减去之前的最大值
            if (flags[i]) {
                res = Math.max(res, minArr[i] - lastMax);
                lastMax = maxArr[i];
            }
        }
        return res;
    }

    private static int bucket(long num, long len, long max, long min) {
        return (int)((num - min) * len / (max - min));
    }

    /**
     * 使用二分查找, 二分查找最关键的是确定范围,
     * 左边界0, 右边界 arr.length - 1, 终止条件是 l <= r, 步进语句是 l = mid + 1, r = mid - 1;
     * 左边界0, 右边界 arr.length, 终止条件是 l < r, 步进语句是 l = mid + 1, r = mid;
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }
    private static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j])
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
