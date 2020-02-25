package com.zl.array;

import java.util.Arrays;

public class ArrayRemove {

    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        removeElement(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, ++r, i);
            }
        }
        return r;
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
