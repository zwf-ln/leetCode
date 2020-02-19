package com.zl.array;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 3, 6, 7};
//        bubbleSort(arr);

        System.out.println(Arrays.toString(insertSort(arr)));
        // swap(arr, 0, 0);
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     */

    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //结束标识符, 如果一轮循环,没有任何数据交换,可以认为是排好序的了
        boolean isEnd = true;
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isEnd = false;
                }
            }
            if (isEnd) {
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     *
     * @return
     */
    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            //默认当前为最小索引
            int minIndex = i;
            //找到最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i) {
                //和当前位置交换,每次循环保证当前位置都是余下的最小值
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {

            //默认当前位置是有序的,插入一个值,把插入的值放到合适的位置
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j +1);
            }
        }
        return arr;
    }

    //    private static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] + arr[j];
//        arr[j] = arr[i] - arr[j];
//        arr[i] = arr[i] - arr[j];
//    }
    private static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
