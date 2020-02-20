package com.zl.num;

import java.util.Arrays;

public class FindNumber {
    public static void main(String[] args) {
        int[] arr = {5,3,5,8,3,2,4,7,1,9,6,7,5};
        System.out.println(Arrays.toString(changeNum1(arr, 5)));
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
    private static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j])
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
