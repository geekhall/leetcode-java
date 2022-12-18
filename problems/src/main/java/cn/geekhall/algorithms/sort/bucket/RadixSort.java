package cn.geekhall.algorithms.sort.bucket;

import cn.geekhall.algorithms.basic.ArrayUtils;

/**
 * RadixSort.java
 *
 * @author yiny
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[] {26,17,21,100,74};
        ArrayUtils.printArr(arr);
//        radixSort(arr);
//        ArrayUtils.printArr(arr);
        System.out.println(maxbits(arr));
    }
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 获取一个数组中所有元素中最大值的位数
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * 基数排序
     * @param arr 待排序的数组
     * @param l   左边界
     * @param r   有边界
     * @param digit 数组arr中最大值的位数。
     */
    public static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数就准备多少个辅助空间。
        int[] bucket = new int[r - l + 1];
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            // 10个空间
            // count[0] 当前为（d位）是0的数字有多少个
            // count[1] 当前为（d位）是（0和1）的数字有多少个
            // count[2] 当前为（d位）是（0，1，2）的数字有多少个
            // count[i] 当前为（d位）是（0~i）的数字有多少个
            int[] count = new int[radix];    // count[0..9]
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i-1];
            }

            // 所有数字出桶
            for (i = r; i >= l; i--) {
                i = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i=l, j = 0; i<=r; i++, j++ ) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x/((int) Math.pow(10, d-1)))%10);
    }
}
