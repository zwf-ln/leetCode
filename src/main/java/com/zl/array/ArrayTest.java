package com.zl.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i =0; i<10000000; ++i) {
            arr[i] = (int)(Math.random() * 1000000000);
        }
        long start = System.currentTimeMillis();
        int max = getMax2(arr, 0, -1);
        long end = System.currentTimeMillis();
        Arrays.sort(arr);
        System.out.println(arr[9999999]);
        System.out.println(max);
        System.out.println(end - start);
        System.out.println(start);
    }

    public static int getMax(int[] arr, int left, int right) {
        if (left >= right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int maxLeft = getMax(arr, left, mid);
        int maxRight = getMax(arr, mid + 1, right);
        return Math.max(maxLeft, maxRight);
    }

    public static int getMax2(int[] arr, int i, int max) {
        if (i >= arr.length) {
            return max;
        }
        if (max > arr[i])
            return getMax2(arr, i + 1, max);
        else
            return getMax2(arr, i + 1, arr[i]);
    }
}
