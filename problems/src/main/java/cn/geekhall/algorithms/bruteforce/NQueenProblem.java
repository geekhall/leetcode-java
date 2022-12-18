package cn.geekhall.algorithms.bruteforce;

/**
 * NQueenProblem.java
 * N皇后问题
 *
 * @author yiny
 */
public class NQueenProblem {

    public static int getAnswer(int n) {
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * N 皇后问题递归求解函数
     *
     * @param index 当前行数
     * @param record index以前已经落定的皇后列位置
     * @param total 总皇后个数
     * @return record条件下的合法解的个数。
     */
    public static int process(int index, int[] record, int total) {
        if (index == total) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < total; i++) {
            if (isValid(record, index, i)) {
                record[index] = i;
                res += process(index + 1, record, total);
            }
        }
        return res;
    }

    /**
     * 求解N皇后问题
     *
     * @param n 皇后的数量，请不要超过32，会时间过长
     * @return  N皇后问题解的数量
     */
    public static int getAnswer2(int n) {
        if (n < 1 || n > 32) return 0;
        // mask bit value , 最右侧n个bit为1，其余bit为0 。
        int mask = n == 32 ? -1 : (1 << n) - 1;
        return process2(mask, 0, 0, 0);
    }

    /**
     * 使用位运算来表示皇后，算法效率更加优化
     *
     * @param mask      最右侧n个bit为1，其余bit为0 。
     * @param colLim    列限制，值为1的bit位置不能放置皇后，为0的bit可以
     * @param leftLim   左斜线限制，值为1的bit位置不能放置皇后，为0的bit可以
     * @param rightLim  右斜线限制，值为1的bit位置不能放置皇后，为0的bit可以
     * @return
     */
    public static int process2(int mask, int colLim, int leftLim, int rightLim) {
        if (colLim == mask) { // base case
            return 1; // 所有列上都有皇后，说明碰到了一个合理解。
        }

        // 所有可以选择的候选皇后的位置，都在pos上
        // colLim | leftLim | rightLim ： 总限制
        int pos = mask & ( ~(colLim | leftLim | rightLim));
        int mostRightBit = 0;
        int res = 0;
        while (pos != 0) { // 按位遍历可选位置。
            // 提取出pos中的最右侧位
            mostRightBit = pos & (~pos + 1);

            pos = pos - mostRightBit;
            res += process2(mask,
                    colLim | mostRightBit,
                    (leftLim|mostRightBit) << 1,
                    (rightLim|mostRightBit) >>> 1); // >> 与 >>> 的区别在于，负数时 >> 高位补1，而 >>> 高位补0
        }
        return res;
    }

    /**
     * 判断当前皇后位置是否合理
     *
     * @param record 之前已经落定的皇后
     * @param row    即将落定的皇后的行
     * @param col    即将落定的皇后的列
     * @return  [row, col] 位置的皇后是否合法。
     */
    public static boolean isValid(int[] record, int row, int col){

        for (int i = 0; i < row; i++) {// 遍历之前已经落定的皇后

            // 与某个皇后共列，或者共斜线
            if (col == record[i] || Math.abs(record[i] - col) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
//        for (int i = 1; i <= 10; i++) {
//            int[] record = new int[i];
//            System.out.println(String.valueOf(i) + " : " + process(0, record, i));
//        }

        int total = 14;
        long start = System.currentTimeMillis();
        System.out.println(getAnswer(total));
        long end = System.currentTimeMillis();
        System.out.println("Cost time : " + (end - start) + "ms");

        long start2 = System.currentTimeMillis();
        System.out.println(getAnswer2(total));
        long end2 = System.currentTimeMillis();
        System.out.println("Cost time : " + (end2 - start2) + "ms");

    }
}
