package cn.geekhall.algorithms.bruteforce;

/**
 * 从左往右的尝试模型1
 *
 * 规定1和A对应、2和B对应、3和C对应。。。
 * 那么一个数字字符串比如"111"就可以转化为：
 * "AAA"，"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果。
 */
public class ConvertToLetterProblem {
    /**
     *
     * @param str
     * @return
     */
    public static int getResult(String str) {
        if (str == null || str.length() == 0) return 0;
        return process(str.toCharArray(), 0);
    }

    /**
     *
     * @param str
     * @param i
     * @return
     */
    private static int process(char[] str, int i) {
        // i到终止位置
        if (i == str.length) {
            return 1;
        }
        // i没有到终止位置
        if (str[i] == '0'){
            return 0;
        }
        // i没有到终止位置，i位置值为1时，总有两种选择
        if (str[i] == '1') {
            int res = process(str, i + 1); // i位置转为A，后续i+1位置以后作为整体
            if (i + 1 < str.length) {
                res += process(str, i + 2); // i位置与i+1一起转为K，后续i+2位置以后作为整体
            }
            return res;
        } else if (str[i] == '2') {
            int res = process(str, i + 1);
            // i位置与i+1位置一起超过26的话无法转化为字母
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1]  <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i+1);
    }

    /**
     * DP方式的处理过程。
     * @param s
     * @return
     */
    private static int processDP(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;
        for (int i = N-1; i >= 0; i--) {
            if (str[i] == '0') return 0;
            // i没有到终止位置，i位置值为1时，总有两种选择
            if (str[i] == '1') {
                dp[i] = dp[i + 1]; // i位置转为A，后续i+1位置以后作为整体
                if (i + 1 < str.length) {
                    dp[i] += dp[i + 2]; // i位置与i+1一起转为K，后续i+2位置以后作为整体
                }
            } else if (str[i] == '2') {
                dp[i] = dp[i + 1];
                // i位置与i+1位置一起超过26的话无法转化为字母
                if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1]  <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(getResult("1111"));
        System.out.println(processDP("1111"));
    }
}
