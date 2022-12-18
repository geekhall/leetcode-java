package cn.geekhall.algorithms.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入:正数数组costs、正数数组profits、正数K、正数M
 * costs[i]   : 表示i号项目的花费
 * profits[i] : 表示i号项目在扣除花费之后还能挣到的钱(利润)
 * K 表示你只能串行的最多做k个项目
 * M 表示你初始的资金
 * 说明:每做完一个项目，马上获得的收益，可以支持你去做下一个项目。不能并行的做项目。
 * 输出:你最后获得的最大钱数。
 */
public class MaxProfitProblem {
    public static int findMaximizedCapital(int maxNum, int initial, int[] profits, int[] capital) {
        PriorityQueue<Program> minCostQueue = new PriorityQueue<>();

        PriorityQueue<Program> maxProfitQueue = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < profits.length; i++) {
            minCostQueue.add(new Program(capital[i], profits[i]));
        }

        for (int i = 0; i < maxNum; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= initial) {
                maxProfitQueue.add(minCostQueue.poll()); // 小根堆弹出的项目进入到大根堆中去。
            }
            if (maxProfitQueue.isEmpty()) {
                return initial;
            }
            initial += maxProfitQueue.poll().profit;
        }
        return initial;
    }

    public static class Program{
        public int cost;
        public int profit;
        public Program(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }

    }


    private static class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o1.profit;
        }
    }


}
