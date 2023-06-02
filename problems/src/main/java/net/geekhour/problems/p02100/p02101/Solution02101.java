package net.geekhour.problems.p02100.p02101;

import java.util.*;

/**
 * ID: 02101
 * Title: Detonate the Maximum Bombs
 * Difficulty: Medium
 * Description: You are given a list of bombs. The range of a bomb is defined as
 * the area where its effect can be felt. This area is in the shape of a circle
 * with the center as the location of the bomb.
 *
 * The bombs are represented by a 0-indexed 2D integer array bombs where
 * bombs[i] = [x i, y i, r i ]. x i and y i denote the X-coordinate and
 * Y-coordinate of the location of the i th bomb, whereas r i denotes the radius
 * of its range.
 *
 * You may choose to detonate a single bomb. When a bomb is detonated, it will
 * detonate all bombs that lie in its range. These bombs will further detonate
 * the bombs that lie in their ranges.
 *
 * Given the list of bombs, return the maximum number of bombs that can be
 * detonated if you are allowed to detonate only one bomb.
 *
 * Example 1:
 *
 * Input: bombs = [[2,1,3],[6,1,4]] Output: 2 Explanation: The above figure
 * shows the positions and ranges of the 2 bombs. If we detonate the left bomb,
 * the right bomb will not be affected. But if we detonate the right bomb, both
 * bombs will be detonated. So the maximum bombs that can be detonated is max(1,
 * 2) = 2.
 *
 * Example 2:
 *
 * Input: bombs = [[1,1,5],[10,10,5]] Output: 1 Explanation: Detonating either
 * bomb will not detonate the other bomb, so the maximum number of bombs that
 * can be detonated is 1.
 *
 * Example 3:
 *
 * Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]] Output: 5
 * Explanation: The best bomb to detonate is bomb 0 because: - Bomb 0 detonates
 * bombs 1 and 2. The red circle denotes the range of bomb 0. - Bomb 2 detonates
 * bomb 3. The blue circle denotes the range of bomb 2. - Bomb 3 detonates bomb
 * 4. The green circle denotes the range of bomb 3. Thus all 5 bombs are
 * detonated.
 *
 * Constraints:
 *
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= x i, y i, r i <= 10 5
 */
class Solution02101 {
  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    int maxBombs = 0;
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (Math.pow(bombs[i][2], 2) >= Math.pow(bombs[i][0] - bombs[j][0], 2)
            + Math.pow(bombs[i][1] - bombs[j][1], 2)) {
          List<Integer> neighbors = graph.getOrDefault(i, new ArrayList<>());
          neighbors.add(j);
          graph.put(i, neighbors);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      Set<Integer> visited = new HashSet<>();
      visited.add(i);
      dfs(i, visited, graph);
      maxBombs = Math.max(maxBombs, visited.size());
    }

    return maxBombs;
  }

  private void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
    List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
    for (int child : neighbors) {
      if (!visited.contains(child)) {
        visited.add(child);
        dfs(child, visited, graph);
      }
    }
  }

  public static void test_02101() {
    Solution02101 solution = new Solution02101();
    int result1 = solution.maximumDetonation(new int[][] { { 2, 1, 3 }, { 6, 1, 4 } });
    int result2 = solution.maximumDetonation(new int[][] { { 1, 1, 5 }, { 10, 10, 5 } });
    int result3 = solution
        .maximumDetonation(new int[][] { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } });
    System.out.println("result1: " + result1);
    System.out.println("result2: " + result2);
    System.out.println("result3: " + result3);
  }

  public static void main(String[] args) {
    Solution02101.test_02101();
  }
}
