package cn.geekhall.algorithms.bruteforce;

/**
 * 从左往右的尝试模型2（比较经典的背包问题）
 *
 * 给定两个长度都为N的数组weights和values，
 * weights[i] 和 values[i]分别代表i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 */
public class KnapsackProblem {
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    /**
     * 求当前位置index往后的最大总价值。
     *
     * @param w         货物的重量
     * @param v         货物的价值
     * @param index     当前位置
     * @param curWeight 当前的负重
     * @param bag       背包负载
     * @return 返回从index位置往后能够取得的最大数量的总价值。
     */
    private static int process(int[] w, int[] v, int index, int curWeight, int bag) {
        if (curWeight > bag) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        // 没有要当前位置的货物，index+1以后的货物会产生多少价值。
        int p1 = process(w, v, index + 1, curWeight, bag);
        // 要了当前位置的货物，index+1以后的货物会产生多少价值。
        int p2next = process(w, v, index + 1, curWeight + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }
    public static int getMaxValue2(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    /**
     * 只剩下rest的空间了，
     * index...货物自由选择，但不要超过rest的空间
     * @param w
     * @param v
     * @param index
     * @param rest
     * @return 能够获得的最大价值
     */
    private static int process(int[] w, int[] v, int index, int rest) {
        // 没空间了
        if (rest <= 0) return 0;
        // 没货了
        if (index == w.length) return 0;

        int p1 = process(w, v, index + 1, rest);
        int p2 = Integer.MIN_VALUE;
        if (rest >= w[index]) {
            p2 = v[index] + process(w, v, index + 1, rest-w[index]);
        }
        return Math.max(p1, p2);
    }

    public static int getMaxValueDP(int[] w, int[] v, int bag) {
        return processDP(w, v, bag);
    }

    /**
     * 只剩下rest的空间了，
     * index...货物自由选择，但不要超过rest的空间
     * @param w
     * @param v
     * @param bag
     * @return 能够获得的最大价值
     */
    private static int processDP(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= bag; rest++) {
                dp[i][rest] = dp[i + 1][rest];
                if (rest >= w[i]) {
//                    dp[i][rest] = Math.max(dp[i][rest], v[i] + dp[i+1][rest]);

                    int p1 = dp[i + 1][rest];
                    int p2 = Integer.MIN_VALUE;
                    if (rest >= w[i]) {
                        p2 = v[i] + dp[i + 1][rest-w[i]];
                    }
                    dp[i][rest] = Math.max(p1,p2);
                }
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weight = new int[]{1,4,5,6,8};
        int[] value = new int[]{2,6,9,3,10};
        int bag = 10;
        System.out.println(getMaxValue(weight,value,bag));
        System.out.println(getMaxValue2(weight,value,bag));
        System.out.println(getMaxValueDP(weight,value,bag));
    }

}
