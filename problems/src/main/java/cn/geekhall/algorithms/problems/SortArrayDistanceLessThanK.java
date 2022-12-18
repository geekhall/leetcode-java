package cn.geekhall.algorithms.problems;

import java.util.PriorityQueue;

/**
 * SortArrayDistanceLessThanK.java
 *
 * 题目：给定一个几乎有序的数组（指数组中每个元组排序后移动的距离不会超过k，并且k相对于数组来说比较小）
 *      选择一个合适的排序算法进行排序。
 * @author yiny
 */
public class SortArrayDistanceLessThanK {
    public static void sort(int[] arr, int k) {

        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;

        // 先把前数组中的前几个数值放到小根堆里去。
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }

        // 加一个到heap中然后弹出一个到arr中。
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }

        // 弹出heap中最后的几个元素。
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
