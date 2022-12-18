package cn.geekhall.algorithms.bruteforce;

/**
 * 给定一个正整数N,表示有N份青草统一堆放在仓库里
 * 有一只牛和一只羊，牛先吃，羊后吃，它俩轮流吃草
 * 不管是牛还是羊，每一轮能吃的草量必须是：
 * 1. 4, 16, 64...（4的某次方）
 * 谁最先把草吃完，谁获胜
 * 假设牛和羊都绝顶聪明，都想赢，都会做出理性的决定
 * 根据唯一的参数N，返回谁会赢
 */
public class EatGrassProblem {
    /**
     * n份情操放在一堆
     * 限售后手都绝顶聪明
     * @param n
     * @return  胜者：先手/后手
     */
    public static String winner(int n) {
        // 0  1  2  3  4
        // 后 先  后 先 先
        if (n < 5){
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        int base = 1; // 当前先手决定吃的草的数量

        while (base <= n) {
            if (winner(n - base).equals("后手")) return "先手"; // n-base为先手选完留给后手的草的数量。
            if (base > n / 4) break; // 防止base*4溢出
            base*= 4;
        }
        return "后手";
    }

    /**
     * 打表法
     * @param n
     * @return
     */
    public static String winnerPrintTable(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <=50; i++) {
            System.out.println(i + " : " + winner(i));
        }
    }
}
