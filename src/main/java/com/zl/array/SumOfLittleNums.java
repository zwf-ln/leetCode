package com.zl.array;

public class SumOfLittleNums {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5};
        int i = littleNums(arr);
        System.out.println(i);
    }

    /**
     * 求小数和
     * 1.什么是小数
     * 数组: [1,3,5,7,2]
     * 从数组当前位置开始左边比它小的数都叫小数
     * 1是最左边 ,没有小数
     * 3左边的小数是 1
     * 5左边的小数是 1, 3
     * 7左边的小数是 1, 3, 5
     * 2左边的小数是 1
     * 所以小数和是 1 + 1 + 3 + 1 + 3 + 5 + 1 = 15
     * <p>
     * 思路: 求小数和 就是看当前位置的数, 右边有多少个比当前数大的数,然后计算
     * 比如示例中 1的右边有4个比它大的数, 3 的右边有两个比它大的数 依次类推
     * 结果就是: 1 * 4 + 3 * 2 + 5 = 15;
     * 可以使用归并排序计算, 在排序的同时记录当前比自己大的数有几个
     */
    public static int littleNums(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        return sortNums(arr, 0, arr.length - 1);
    }

    private static int sortNums(int[] arr, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return sortNums(arr, l, mid)
                + sortNums(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            //如果求逆序对, 即右边有多少比左边小的数
            if (arr[p1] > arr[p2]) {
//                res += (r - p2 + 1) * arr[p1];
                System.out.println(arr[p1] + "----" + arr[p2]);
                help[i++] = arr[p1++];
            } else {
//                if (arr[p1] > arr[p2]) {
//                }
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= l) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
        return res;
    }


}
