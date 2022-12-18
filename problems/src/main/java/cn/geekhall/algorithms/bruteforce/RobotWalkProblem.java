package cn.geekhall.algorithms.bruteforce;

/**
 * NPositionProblem.java
 *
 * 假设有排成一行的 total 个位置，记为 1 ~ total，total 一定大于或等于2
 * 开始时机器人在其中的 start 位置上，（ start 一定是 1~total 中的一个）
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往右来到N-1位置；
 * 如果机器人来到中间位置，那么下一步可以往左或者往右走；
 * 规定机器人必须走step步，最终能来到pos位置（pos也是1~N中的一个）的方法有多少种。
 * 给定四个参数 N，start，step， pos，返回方法数。
 * 阿里某年原题
 *
 * @author yiny
 */
public class RobotWalkProblem {

    /**
     * total个位置，从start点触发，还剩step步，返回最终能够到达pos的方法。
     *
     * @param total 总个数，固定参数
     * @param start 开始位置
     * @param step  步数
     * @param pos   位置
     * @return      可行的方法数
     */
    public static int ways(int total, int start, int step, int pos) {
        if (total < 2 || step < 1 || start < 1 || step > total || pos < 1 || pos > total)
            return 0;

        // 总共total个位置，从start点触发，还剩step步，返回最终能够到达pos的方法。
        return walk(total, start, step, pos);
    }


    /**
     * total个位置，从start点触发，还剩step步，返回最终能够到达pos的方法。
     *
     * @param total 总个数，固定参数
     * @param cur   当前位置
     * @param rest  剩余步数
     * @param pos   位置
     * @return      可行的方法数
     */
    private static int walk(int total, int cur, int rest, int pos) {
        // 如果没有剩余步数了，当前cur位置就是最后的位置。
        // 如果最后停在pos位置，那么之前做的移动是有效的
        // 如果最后没在pos位置，那么之前做的移动是无效的
        if (rest == 0) return cur == pos ? 1 : 0;

        // 1位置只能右移
        if (cur == 1) return walk(total, 2, rest - 1, pos);

        // total位置只能左移
        if (cur == total) return walk(total, total - 1, rest - 1, pos);

        return walk(total, cur - 1, rest - 1, pos) + walk(total, cur + 1, rest - 1, pos);
    }

    /**
     * total个位置，从start点触发，还剩step步，返回最终能够到达pos的方法。
     * 使用缓存优化的算法 (记忆化搜索 - 动态规划的一种)
     *
     * @param total 总个数，固定参数
     * @param start 开始位置
     * @param step  步数
     * @param pos   位置
     * @return      可行的方法数
     */
    public static int waysWithCache(int total, int start, int step, int pos) {
        if (total < 2 || step < 1 || start < 1 || step > total || pos < 1 || pos > total)
            return 0;

        int[][] dp = new int[total + 1] [step + 1];
        for ( int row = 0; row <= total; row++) {
            for (int col = 0; col <= step; col++) {
                dp[row][col] = -1;
            }
        }

        // 总共total个位置，从start点触发，还剩step步，返回最终能够到达pos的方法。
        return walkWithCache(total, start, step, pos, dp);
    }


    /**
     * total个位置，从start点触发，还剩step步，返回最终能够到达pos的方法。
     * 使用缓存优化的算法 (记忆化搜索 - 动态规划的一种)
     *
     * @param total 总个数，固定参数
     * @param cur   当前位置
     * @param rest  剩余步数
     * @param pos   位置
     * @return      可行的方法数
     */
    private static int walkWithCache(int total, int cur, int rest, int pos, int[][] dp) {

        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        // 如果没有剩余步数了，当前cur位置就是最后的位置。
        // 如果最后停在pos位置，那么之前做的移动是有效的
        // 如果最后没在pos位置，那么之前做的移动是无效的
        if (rest == 0) {
            dp[cur][rest] = cur == pos ? 1 : 0;
            return dp[cur][rest];
        }

        // 1位置只能右移
        if (cur == 1) {
            dp[cur][rest] = walkWithCache(total, 2, rest - 1, pos, dp);
            return dp[cur][rest];
        }

        // total位置只能左移
        if (cur == total){
            dp[cur][rest] =  walkWithCache(total, total - 1, rest - 1, pos, dp);
            return dp[cur][rest];
        }

        dp[cur][rest] = walkWithCache(total, cur - 1, rest - 1, pos, dp)
                + walkWithCache(total, cur + 1, rest - 1, pos, dp);
        return dp[cur][rest];
    }


    public static void main(String[] args) {
        // 1 2 3 4 5 6 (答案为3)
        // 3 => 4 => 5 => 4
        // 3 => 4 => 3 => 4
        // 3 => 2 => 3 => 4
        System.out.println(ways(6, 3, 3, 4));
        long start = System.currentTimeMillis();
        System.out.println(waysWithCache(600, 300, 30, 310));
        long end = System.currentTimeMillis();
        System.out.println("Total cost : " + String.valueOf(end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(ways(600, 300, 30, 310));
        end = System.currentTimeMillis();
        System.out.println("Total cost : " + String.valueOf(end - start) + "ms");
    }
}
