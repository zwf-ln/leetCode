package com.zl.array;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 3, 6, 7};
//        bubbleSort(arr);

        System.out.println(Arrays.toString(mergeSort(arr)));
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

    /**
     * 插入排序
     * @param arr
     * @return
     */
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

    /**
     * 归并排序, 排得过程中插入到新数组;
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        sortArray(arr, 0, arr.length - 1);
        return arr;
    }
    private static void sortArray(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 2);
        sortArray(arr, l, mid);
        sortArray(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        //mid 以及 r都是闭合点,因此要 <=
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
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
