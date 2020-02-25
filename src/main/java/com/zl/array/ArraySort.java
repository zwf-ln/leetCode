package com.zl.array;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 3, 6, 7};
//        bubbleSort(arr);

        System.out.println(Arrays.toString(heapSort(arr)));
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
     *
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
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    /**
     * 归并排序, 排得过程中插入到新数组;
     *
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
        int mid = l + ((r - l) >> 1);
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
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
    }

    public static int[] quickSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] partition = getPartition(arr, l, r);
            quickSort(arr, l, partition[0] - 1);
            quickSort(arr, partition[1] + 1, r);
        }
        return arr;
    }

    private static int[] getPartition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        //交换more位置和最后一个值
        swap(arr, more, r);
        //注意: less位置的数是小于arr[r]的, more位置的数由于和arr[r]做了交换, 等于arr[r]
        return new int[]{less + 1, more};
    }

    /**
     * 堆排序
     * @return
     */
    public static int[] heapSort(int[] arr) {
        /**
         * 1. 先构建大根堆,
         * 2. 此时跟上的元素是最大值, 去掉根, 重新组建大根堆
         */
        if (checkArr(arr)) {
            return arr;
        }
        //创建大根堆, 此时堆顶元素即为最大值
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //对数组进行排序
        int length = arr.length - 1;
        swap(arr, 0, length);
        while (length > 1) {
            heapify(arr, length--);
            swap(arr, 0 , length);
        }
        return arr;
    }

    private static void heapify(int[] arr, int length) {
        int i = 0;
        int l = 2 * i + 1;
        while (l < length) {
            //判断出左右孩子中值最大的索引
            int largeIndex = l + 1 > length - 1 ? l : (arr[l] > arr[l + 1] ? l : l + 1);
            //判断是否比当前值要大
            largeIndex = arr[largeIndex] > arr[i] ? largeIndex : i;
            //如果堆顶元素仍然是最大的, 则结束循环
            if (largeIndex == i) {
                break;
            }
            //堆顶元素小于左右节点的值, 交换, 然后把交换后的值,继续循环和子节点比较,直到完成堆化
            swap(arr, largeIndex, i);
            i = largeIndex;
            l = 2 * i + 1;
        }
    }

    private static void heapInsert(int[] arr, int i) {
        //如果当前值比根节点要大, 替换掉根节点,
        //并把当前索引置换到根节点,继续向上比较
        for (int head = (i - 1) / 2; arr[i] > arr[head];) {
            swap(arr, i, head);
            i = head;
            head = (i - 1) / 2;
        }
    }

    private static boolean checkArr(int[] arr) {
        if (arr == null || arr.length < 2)
            return true;
        return false;
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
