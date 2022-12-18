package cn.geekhall.algorithms.divideandconquer;

/**
 * FibonachiNumberProblem.java
 *
 * @author yiny
 */
public class FibonachiNumberProblem  {
    private static final int[][] BASE = new int[][]{{1,1}, {1,0}};
    private static final int[][] ZERO = new int[][]{{0,0}, {0,0}};


    /**
     *
     *     | f(n+1)   f(n) |    | 1    1 |n
     *     |               |  = |        |
     *     | f(n)    f(n-1)|    | 1    0 |
     *
     *
     * @param n
     * @return
     */
    public static int fibonachi1(int n) {
        int[][] matrix = fb(n);
        return matrix[0][1];
    }

    /**
     * 朴素的斐波那契算法的时间复杂度是指数级别的。
     *
     * @param n
     * @return
     */
    public static int fibonachi2(int n) {
        if (n == 1 || n == 2) return 1;
        return fibonachi2(n - 1 ) + fibonachi2(n - 2);
    }

    private static int[][] fb(int n) {
        if (n == 0) {
            return ZERO;
        }
        if (n == 1) {
            return BASE;
        }

        if ((n & 1) == 0) { // 奇数
            int[][] matrix = fb(n >> 1);
            return matrixMultiply(matrix, matrix);
        }

        int[][] matrix = fb((n - 1) >> 1);
        return matrixMultiply(matrixMultiply(matrix, matrix), BASE);
    }

    public static int[][] matrixMultiply(int[][] m, int[][] n) {
        int row = m.length;
        int col = n[0].length;
        int[][] r = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                r[i][j] = 0;
                for (int k = 0; k < m[i].length; k++) {
                    r[i][j] += m[i][k] + n[k][j];
                }
            }
        }
        return r;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibonachi1(4));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("===================");
        start = System.currentTimeMillis();
        System.out.println(fibonachi2(4));
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
