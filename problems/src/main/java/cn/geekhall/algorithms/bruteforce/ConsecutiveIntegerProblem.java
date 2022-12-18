package cn.geekhall.algorithms.bruteforce;

/**
 * 定义一种数：可以表示成若干（数量>1）连续正整数和的数。
 * 比如：
 *   5 = 2 + 3
 *   12 = 3 + 4 + 5
 *   给定一个参数N，返回是不是可以表示成若干连续正整数和的树。
 */
public class ConsecutiveIntegerProblem {
    /**
     * 暴力方式
     * @param num
     * @return
     */
    public static boolean isMSum(int num) {
        for (int i = 1; i <= num; i++) {
            int sum = i;
            for (int j = i + 1; j <= num; j++) {
                if (sum + j > num) {
                    break;
                }
                if (sum + j == num) {
                    return true;
                }
                sum += j;
            }
        }
        return false;
    }

    /**
     * 打表方式
     * @param num
     * @return
     */
    public static boolean isMSum2(int num) {
        if (num < 3) return false;
        return (num & (num - 1)) != 0; // num & (num - 1) 为真表示2的次幂的数字，如1，2，4，16，64等
    }

    public static void main(String[] args) {
        for (int num = 1; num < 200; num++) {
            System.out.println(num + " : " + isMSum(num));
        }
        System.out.println("test begin");
        for (int num = 1; num < 5000; num++) {
            if (isMSum(num) != isMSum2(num)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("test end");
    }
}
