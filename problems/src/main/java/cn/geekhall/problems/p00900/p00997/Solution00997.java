package cn.geekhall.problems.p00900.p00997;

/**
 * ID:    00997
 * Title: Find the Town Judge
 * Difficulty: Easy
 * Description: In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given an array trust where trust[i] = [a i, b i ] representing that the person labeled a i trusts the person labeled b i.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 * Example 1:
 *
 * Input: n = 2, trust = [[1,2]] Output: 2
 *
 * Example 2:
 *
 * Input: n = 3, trust = [[1,3],[2,3]] Output: 3
 *
 * Example 3:
 *
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]] Output: -1
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= trust.length <= 10 4
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * a i!= b i
 * 1 <= a i, b i <= n
 */
class Solution00997 {

  public int findJudge(int n, int[][] trust) {
    int[] trustCount = new int[n + 1];
    for (int[] t : trust) {
      trustCount[t[0]]--;
      trustCount[t[1]]++;
    }
    for (int i = 1; i <= n; i++) {
      if (trustCount[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }

  public static void test_00997() {
    Solution00997 solution = new Solution00997();
    int n = 2;
    int[][] trust = {{1,2}};
    int result = solution.findJudge(n, trust);
    System.out.println(result);
    int n2 = 3;
    int[][] trust2 = {{1,3},{2,3}};
    int result2 = solution.findJudge(n2, trust2);
    System.out.println(result2);
    int n3 = 3;
    int[][] trust3 = {{1,3},{2,3},{3,1}};
    int result3 = solution.findJudge(n3, trust3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution00997.test_00997();
  }
}

