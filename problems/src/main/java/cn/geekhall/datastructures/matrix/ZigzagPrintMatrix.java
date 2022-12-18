package cn.geekhall.datastructures.matrix;

/**
 * 锯齿形（斜向交替上下）打印矩阵
 */
public class ZigzagPrintMatrix {
    /**
     * 锯齿形（斜向交替上下）打印矩阵
     * @param matrix
     */
    public static void printMatrixZigzag(int[][] matrix){
        // A，B两点分别沿着先右再下和先下再右两个方向移动。E为矩阵右下角的终点。
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int er = matrix.length - 1;
        int ec = matrix[0].length - 1;

        // 是否自上向下
        boolean up = false;

        while(ar != er + 1) {
            printOneLine(matrix, ar, ac, br, bc, up); // 斜向打印一行
            ar = ac == ec ? ar + 1 : ar;
            ac = ac == ec ? ac : ac + 1;
            br = br == er ? br : br + 1;
            bc = br == er ? bc + 1 : bc;
            up = !up;
        }
        System.out.println();
    }

    /**
     * 斜向打印一行
     * @param matrix
     * @param ar
     * @param ac
     * @param br
     * @param bc
     * @param up
     */
    public static void printOneLine(int[][] matrix, int ar, int ac, int br, int bc, boolean up) {
        if (up) {
            while (ar != br + 1) {
                System.out.println(matrix[ar++][ac--]);
            }
        }else {
            while (br != ar - 1) {
                System.out.println(matrix[br--][bc--]);
            }
        }
    }

    /**
     * 矩阵顺时针90度螺旋打印
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int ar = 0;
        int ac = 0;
        int br = matrix.length - 1;
        int bc = matrix[0].length - 1;
        while(ar <= br && ac <= bc) {
            printEdge(matrix, ar++, ac++, br--, bc--);
        }
    }

    /**
     * 打印一条边
     * @param matrix
     * @param ar
     * @param ac
     * @param br
     * @param bc
     */
    private static void printEdge(int[][] matrix, int ar, int ac, int br, int bc){
        if (ar == br) {
            for (int i = ac; i < bc; i++) {
                System.out.println(matrix[ar][i] + " ");
            }
        } else if (ac == bc) {
            for (int i = ar; i <= br; i++) {
                System.out.println(matrix[i][ac] + " ");
            }
        } else {
            int curC = ac;
            int curR = ar;
            while (curC != bc) {
                System.out.println(matrix[ar][curR] + " ");
                curC++;
            }
            while (curR != br) {
                System.out.println(matrix[curR][bc] + " ");
                curR++;
            }
            while (curC != ac) {
                System.out.println(matrix[br][curC] + " ");
                curC--;
            }
            while (curR != ar) {
                System.out.println(matrix[curR][ac] + " ");
                curR--;
            }
        }
    }

    /**
     * 原地旋转正方形矩阵
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length -1;
        int d = matrix[0].length - 1;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    /**
     *
     * @param matrix
     * @param a
     * @param b
     * @param c
     * @param d
     */
    private static void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
        int tmp = 0;
        for (int i = 0; i < d - b; i++) {
            tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
        }
    }

    /**
     * 矩阵打印
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("matrix test");
    }
}
