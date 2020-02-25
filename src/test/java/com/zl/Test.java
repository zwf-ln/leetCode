package com.zl;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        int[] arr = {3,2,6,5,3,8,5,1};
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//        int a = lengthOfLastWord("a ");
//        System.out.println(a);
//        char a = '0';
//        char b = '2';
//        System.out.println( a + "");
//        System.out.println(mySqrt(2147395599));
        int[] arr1 = {2,0};
        int[] arr2 = {1};
        merge(arr1, 1, arr2, 1);
        System.out.println(Arrays.toString(arr1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0) return;
        if (nums2 == null || nums2.length == 0) return;
        if (nums1.length < (m + n)) return;
        if (nums1[m - 1] <= nums2[0]) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        if (nums1[0] >= nums2[n - 1]) {
            System.arraycopy(nums1, 0, nums1, n, m);
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int i = m + n - 1;
        while (i >= 0 && m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
            --i;
        }
        if (n > 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
    }
    public static int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)) return 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            --end;
        }
        int len = end;
        while (end >= 0 && s.charAt(end) != ' ') {
            --end;
        }
        return len - end;
    }

    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1;
        int r = x;
        int mid = 0;
        long res = 0L;
        while (l <= r) {
            mid = l + (r - l) / 2;
            res = (long)mid * mid;
            if (res > x) {
                r = mid - 1;
            } else if (res < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l - 1;
    }

    public static void heapSort(int[] arr) {
        heapSort(arr, 0, arr.length - 1);
    }

    private static void heapSort(int[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            heapInsert(arr, i);
        }
        //堆化完成后, 根节点就是最大值,及arr[0]是最大的,
        //把根节点的值和最后一个值交换, 然后重新堆化, 每次取根节点的值,和最后一个节点交换
        swap(arr, l, r);
        //此时跟元素已经不是最大的, 需要和子节点比较, 重新生成大根堆
        while (r > 0) {
            heapfy(arr, l, r--);
            swap(arr, l, r);
        }
    }

    private static void heapfy(int[] arr, int root, int len) {
        // root是根节点, len是堆中元素个数

        for (int l = root * 2 + 1; l < len; l = root * 2 + 1) {
            //获取左右节点较大的
            int large = l + 1 >= len ? l : arr[l] > arr[l + 1] ? l : l + 1;
            large = arr[large] > arr[root] ? large : root;
            if (large == root) break;
            swap(arr, large, root);
            root = large;
        }
    }

    private static void heapInsert(int[] arr, int i) {
        //一直和自己的父节点比较, 如果比父节点大,就浮上去
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
