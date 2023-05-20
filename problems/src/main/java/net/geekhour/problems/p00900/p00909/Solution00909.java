package net.geekhour.problems.p00900.p00909;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 00909
 * Title: Snakes and Ladders
 * Difficulty: Medium
 * Description: You are given an n x n integer matrix board where the cells are
 * labeled from 1 to n 2 in a Boustrophedon style starting from the bottom left
 * of the board (i.e. board[n - 1][0]) and alternating direction each row.
 *
 * You start on square 1 of the board. In each move, starting from square curr,
 * do the following:
 *
 * Choose a destination square next with a label in the range [curr + 1,
 * min(curr + 6, n 2)].
 *
 * This choice simulates the result of a standard 6-sided die roll: i.e., there
 * are always at most 6 destinations, regardless of the size of the board.
 *
 * If next has a snake or ladder, you must move to the destination of that snake
 * or ladder. Otherwise, you move to next.
 * The game ends when you reach the square n 2.
 *
 * A board square on row r and column c has a snake or ladder if board[r][c] !=
 * -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n 2
 * do not have a snake or ladder.
 *
 * Note that you only take a snake or ladder at most once per move. If the
 * destination to a snake or ladder is the start of another snake or ladder, you
 * do not follow the subsequent snake or ladder.
 *
 * For example, suppose the board is [[-1,4},{-1,3]], and on the first move,
 * your destination square is 2. You follow the ladder to square 3, but do not
 * follow the subsequent ladder to 4.
 *
 * Return the least number of moves required to reach the square n 2. If it is
 * not possible to reach the square, return -1.
 *
 * Example 1:
 *
 * Input: board =
 * [[-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1]]
 * Output: 4 Explanation: In the beginning, you start at square 1 (at row 5,
 * column 0). You decide to move to square 2 and must take the ladder to square
 * 15. You then decide to move to square 17 and must take the snake to square
 * 13. You then decide to move to square 14 and must take the ladder to square
 * 35. You then decide to move to square 36, ending the game. This is the lowest
 * possible number of moves to reach the last square, so return 4.
 *
 * Example 2:
 *
 * Input: board = [[-1,-1},{-1,3]] Output: 1
 *
 * Constraints:
 *
 * n == board.length == board[i].length
 * 2 <= n <= 20
 * grid[i][j] is either -1 or in the range [1, n 2 ].
 * The squares labeled 1 and n 2 do not have any ladders or snakes.
 */
class Solution00909 {

  public int snakesAndLadders(int[][] board) {
    int n = board.length;

    int[] nums = new int[n * n + 1];
    int index = 1;
    boolean flag = true;
    // 从左下角开始，按照蛇形顺序，将数字放入数组中
    for (int i = n - 1; i >= 0; i--) {
      if (flag) {
        for (int j = 0; j < n; j++) {
          nums[index++] = board[i][j];
        }
      } else {
        for (int j = n - 1; j >= 0; j--) {
          nums[index++] = board[i][j];
        }
      }
      flag = !flag;
    }
    // 从1开始，每次走1-6步，如果遇到蛇或者梯子，就跳到蛇或者梯子的终点
    // 如果遇到0，说明还没有走过，就把当前步数+1，放入队列中
    // 如果遇到非0，说明已经走过，就不用再走了
    // 如果遇到n*n，说明已经走到终点了，返回当前步数-1
    // 如果遍历完队列，还没有遇到n*n，说明无法到达终点，返回-1
    int[] steps = new int[n * n + 1];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    steps[1] = 1;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = 1; i <= 6; i++) {
        int next = cur + i;
        if (next > n * n) {
          break;
        }
        if (nums[next] != -1) {
          next = nums[next];
        }
        if (steps[next] == 0) {
          steps[next] = steps[cur] + 1;
          queue.offer(next);
        }
      }
    }
    return steps[n * n] - 1;
  }

  public static void test_00909() {
    Solution00909 solution = new Solution00909();
    int[][] board = {
        { -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1 },
        { -1, 35, -1, -1, 13, -1 },
        { -1, -1, -1, -1, -1, -1 },
        { -1, 15, -1, -1, -1, -1 } };
    int result = solution.snakesAndLadders(board);
    System.out.println(result);
    int[][] board2 = { { -1, -1 }, { -1, 3 } };
    result = solution.snakesAndLadders(board2);
    System.out.println(result);
    int[][] board3 = { { -1, -1 }, { -1, 1 } };
    result = solution.snakesAndLadders(board3);
    System.out.println(result);
    int[][] board4 = {
        { -1, -1, 2, -1 },
        { 14, 2, 12, 3 },
        { 4, 9, 1, 11 },
        { -1, 2, 1, 16 }
    };
    result = solution.snakesAndLadders(board4);
    System.out.println(result); // 1

  }

  public static void main(String[] args) {
    Solution00909.test_00909();
  }
}
