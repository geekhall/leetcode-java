package cn.geekhall.algorithms.greedy;

import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。
 * 比如长度为20的金条，不管怎么切，都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板?
 *
 * 例如给定数组(10，20，30）代表一共三个人，整块金条长度为60，金条要分成10，20，30三个部分。
 *
 * 如果先把长度60的金条分成10和50花费60，再把长度50的金条分成20和30花费50，一共花费110铜板；
 * 但如果先把长度60的金条分成30和30花费60，再把长度30金条分成10和20，花费30，一共花费90铜板。
 *
 * 输入一个数组，返回分割的最小代价。
 * （霍夫曼树）
 */
public class GoldSplitProblem {

    /**
     * 最小费用分金条（暴力解）
     * @param arr
     * @return
     */
    public static int lessMoneyBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return process(arr, 0);
    }

    private static int process(int[] arr, int pre) {
        if (arr.length == 1) return pre;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
            }
        }
        return ans;
    }

    public static int[] copyAndMergeTwo(int[] arr, int i, int j) {
        int[] ans = new int[arr.length - 1];
        int ansi = 0;
        for (int arri = 0; arri < arr.length; arri++) {
            if (arri != i && arri != j) {
                ans[arri++] = arr[arri];
            }
        }
        ans[ansi] = arr[i] + arr[j];
        return ans;
    }

    /**
     * 最小费用分金条（贪心解）
     * @param arr
     * @return
     */
    public static int lessMoneyGreedy(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();// 小根堆
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (queue.size() > 1) { // 弹出两个数，结合后再扔回小根堆中。
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
}
