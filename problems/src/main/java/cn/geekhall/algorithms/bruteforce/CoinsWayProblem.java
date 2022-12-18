package cn.geekhall.algorithms.bruteforce;

import java.util.HashMap;

/**
 * 给定一组不重复硬币面值的数组和一个目标金额。
 * 求能够组成该目标金额的面值种类个数。
 */
public class CoinsWayProblem {
    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        return process(arr, 0, aim);
    }

    /**
     * 可以自由使用arr中从i位置开始往后的元素，组成rest金额有多少种方法。
     * @param arr  面值数组
     * @param cur    当前位置
     * @param rest 目标金额
     * @return 组成rest金额的方法数
     */
    private static int process(int[] arr, int cur, int rest) {
        if (cur == arr.length) return rest == 0 ? 1 : 0;

        int res = 0;
        for (int zhang = 0; arr[cur] * zhang <= rest; zhang++){
            res += process(arr, cur + 1, rest - arr[cur] * zhang);
        }
        return res;
    }

    public static int dpways(int[] arr, int aim) {
        int N = arr.length;
        if (arr == null || arr.length == 0 || aim < 0) return 0;
//        HashMap<String, Integer> map = new HashMap<>();
        // dp[i][j] 表示使用i位置，剩余j面额的方法；初始化为-1
        int[][] dp = new int[N + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return processDP(arr, 0, aim, dp);
    }

    private static int processDP(int[] arr, int cur, int rest, int[][] dp) {
        if (cur == arr.length) return rest == 0 ? 1 : 0;

        int res = 0;
        for (int zhang = 0; arr[cur] * zhang <= rest; zhang++){
            res += processDP(arr, cur + 1, rest - arr[cur] * zhang, dp);
        }
        dp[cur][rest] = res;
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int aim = 3;
        System.out.println(ways(arr, aim));
        System.out.println(dpways(arr, aim));
    }
}
