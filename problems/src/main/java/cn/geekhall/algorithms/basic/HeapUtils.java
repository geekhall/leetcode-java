package cn.geekhall.algorithms.basic;

import java.util.PriorityQueue;

/**
 * HeapUtils.java
 * 索引从0开始的堆结构：
 *     左孩子：2i+1
 *     右孩子：2i+2
 *     父节点：(i-1)/2
 * 索引从1开始的堆结构：
 *     左孩子：2i   or  i<<1
 *     右孩子：2i+1 or  i<<1|1
 *     父节点：i/2  or  i>>1
 * @author yiny
 */
public class HeapUtils {
    /**
     * 将处于index位置上的某个数插入数组arr中，使其满足堆特性。
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]) {
            swap(arr, index, (index-1)/2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 交换数组arr中pos1和pos2位置的值。
     * @param arr
     * @param pos1
     * @param pos2
     */
    public static void swap(int[] arr, int pos1, int pos2){
        arr[pos1] = arr[pos1] ^ arr[pos2];
        arr[pos2] = arr[pos1] ^ arr[pos2];
        arr[pos1] = arr[pos1] ^ arr[pos2];
    }

    /**
     * 打印数组内容
     * @param arr
     */
    public static void printHeap(int[] arr){
        System.out.print("[");
        for (int i=0; i<arr.length; i++ ){
            System.out.print(arr[i]);
            if ( i == arr.length - 1) {
                System.out.println("]");
            } else {
                System.out.print(", ");
            }
        }
    }

    /**
     * 堆化，某个数在index位置，判断其是否满足大根堆条件并向下移动。
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) { // 下方还有孩子的时候
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;   // 取左右孩子的较大值，将其下标赋值给largest。
            largest = arr[largest] > arr[index] ? largest : index;                          // 取index位置元素与左右孩子中较大的元素比较，将其中较大者的下标赋值给largest。
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;        // 新的index
            left = index * 2 + 1;   // 新的左孩子
        }
    }

    /**
     * 堆排序
     * 把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，堆的大小减小成0之后排序完成。
     * @param arr
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

}
