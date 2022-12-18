package cn.geekhall.algorithms.basic;

public class ArrayUtils {
    public static int getMax(int[] arr){
        return getMax(arr, 0, arr.length - 1);
    }

    /**
     * Get the max value of array in range left to right.
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int getMax(int[] arr, int left, int right){
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    /**
     * 数组归并排序。
     * @param arr
     */
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序内部方法。
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right){
        if (left == right) {
            return;
        }

        int mid = left + ( (right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * Merge array.
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    public static void merge(int[] arr, int l, int m, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        // 将左半部分和右半部分中当前指针指向的较小值拷贝至help数组。
        while(p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 将左半部分或者右半部分中剩余还未拷贝的部分复制到help中。
        while(p1 <= m) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i=0; i< help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    /**
     * Return the two array is equal or not.
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        if ( arr1 == null && arr2 != null || arr1 != null && arr2 == null ) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i= 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print an array.
     * @param arr
     */
    public static void printArr(int[] arr){
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i]);
            if (i == arr.length -1) {
                System.out.println("");
            } else {
                System.out.print(",");
            }
        }
    }

    /**
     * Insertion Sort method for array.
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int i, j;
        for (j=1; j<arr.length; j++){
            int key = arr[j];   // 比较基准关键字
            i = j - 1;
            while (i >= 0 && arr[i] > key){ // 左边的已排序数组从右向左与key依次比较，若大于key则右移
                arr[i+1] = arr[i];          // 右移
                i = i - 1;
            }
            arr[i+1] = key;
        }
    }

    /**
     * Bubble Sort
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int temp;
        for (int i=0; i<arr.length; i++) {
            for (int j = arr.length; j>i+1; j--) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * 交换数组i和j位置上的值。
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize+1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue+1)*Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /**
     * Array copy method.
     * 数组拷贝方法。
     * @param arr
     * @return
     */
    public static int [] copyArray(int[] arr){
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i<arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 返回一个有序数组sortedArr中是否存在数值num。
     * @param sortedArr
     * @param num
     * @return true：存在；false：不存在
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int l = 0;
        int r = sortedArr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l)>>1 ;
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return sortedArr[l] == num;
    }
}
