package cn.geekhall.algorithms.divideandconquer;

/**
 * MatrixMultiply.java
 * 给定两个矩阵A和B，A=[aij] , B = [bij]
 * 计算矩阵的乘积
 *
 * @author yiny
 */
public class MatrixMultiplyProblem {


    /**
     * 朴素的矩阵乘法函数
     * 时间复杂度为O（N^3)
     *
     * @param a Matrix a
     * @param b Matrix b
     * @return  c = a * b
     */
    public static int[][] multiply(int[][] a, int[][] b){

        int n = a.length;
        int[][] res = new int[n][n];

        for ( int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int k = 0; k < n; k++) {
                    temp += (a[i][k] * b[k][j]);
                }
                res[i][j] = temp;
            }
        }
        return res;
    }

    /**
     * Strassen算法，时间复杂度O（Nlog2^7），约为O（N^2.807)
     * Strassen算法只有在对于维数比较大的矩阵 [公式] ，性能上才有很大的优势，可以减少很多乘法计算。
     *
     * 创建10个N/2长度的矩阵
     *      S1 = B12 - B22
     *      S2 = A11 + A12
     *      S3 = A21 + A22
     *      S4 = B21 - B11
     *      S5 = A11 + A22
     *      S6 = B11 + B22
     *      S7 = A12 - A22
     *      S8 = B21 + B22
     *      S9 = A11 - A21
     *      S10 = B11 + B12
     *
     *   |  a, b |    | e, f |
     *   |  c, d |    | g, h |
     *
     *      P1 = a(f - h)       = A11 * S1
     *      P2 = (a + b)h       = S2 * B22
     *      P3 = (c + d)e       = S3 * B11
     *      P4 = d(g - e)       = A22 * S4
     *      P5 = (a + d)(e + h) = S5 * S6
     *      P6 = (b - d)(g + h) = S7 * S8
     *      P7 = (a - c)(e + f) = S9 * S10
     *
     * 进而：
     *   C11 = P5 + P4 - P2 + P6
     *   C12 = P1 + P2
     *   C21 = P3 + P4
     *   C22 = P5 + P1 - P3 - P7
     *   可以将所有乘法操作转换为加法，减少复杂度
     *
     * @param a Matrix a
     * @param b Matrix b
     * @return  c = a * b
     */
    public static int[][] multiply1(int[][] a, int[][] b){

        int n = a.length;

        return null;
    }

    /**
     * 矩阵打印函数
     *
     * @param matrix 要打印的矩阵
     */
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{3,4}};
        int[][] b = new int[][]{{1,0},{0,1}};
        int[][] c = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] d = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        printMatrix(a);
        printMatrix(b);
        printMatrix(multiply(a, b));
        printMatrix(multiply(c, d));
    }
}
