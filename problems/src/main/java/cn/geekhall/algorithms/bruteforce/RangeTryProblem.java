package cn.geekhall.algorithms.bruteforce;

/**
 * 范围上尝试的模型
 *
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线，
 * 玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 */
public class RangeTryProblem {

    /**
     *
     * @param arr 分数牌
     * @return 获胜者的分数
     */
    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    /**
     * 取得先手情况下的最大分数。
     * @param arr   分数牌
     * @param left  左边位置
     * @param right 右边位置
     * @return  先手情况下的最大分数
     */
    private static int first(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) return 0;
        if (left == right) return arr[left];

        int pickLeft = arr[left] + second(arr, left + 1, right);
        int pickRight = arr[right] + second(arr, left, right - 1);
        return Math.max(pickLeft, pickRight);
    }

    /**
     * 取得后手情况下的最小分数。
     * @param arr   分数牌
     * @param left  左边位置
     * @param right 右边位置
     * @return  后手情况下的最小分数
     */
    private static int second(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) return 0;
        if (left == right) return 0;

        // 左边被选走后剩余部分的先手最大分数
        int pickLeft = first(arr, left + 1, right);
        // 右边边被选走后剩余部分的先手最大分数
        int pickRight = first(arr, left, right - 1);

        return Math.min(pickLeft, pickRight);
    }

    public static int dpWay(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int N = arr.length;

        int[][] first = new int[N][N];
        int[][] second = new int[N][N];

        for (int i=0; i<N; i++) {
            first[i][i] = arr[i];
//            second[i][i] = 0; // 可省略
        }
        printMatrix(first);
        System.out.println("");

        for (int i=1; i < N; i++) {
            int left = 0;
            int right = i;
            while (left < N && right < N){
                first[left][right] = Math.max(arr[left] + second[left+1][right], arr[right] + second[left][right-1]);
                second[left][right] = Math.min(first[left+1][right], first[left][right-1]);
                left++;
                right++;
            }
        }
        printMatrix(first);
        System.out.println("");
        printMatrix(second);
        return Math.max(first[0][N - 1], second[0][N - 1]);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,99, 8};
        System.out.println(win(arr));
        System.out.println(dpWay(arr));
    }
}
