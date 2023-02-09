package cn.geekhall.problems.p02300.p02306;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 02306
 * Title: Naming a Company
 * Difficulty: Hard
 * Description: You are given an array of strings ideas that represents a list
 * of names to be used in the process of naming a company. The process of naming
 * a company is as follows:
 *
 * Choose 2 distinct names from ideas, call them idea A and idea B.
 * Swap the first letters of idea A and idea B with each other.
 * If both of the new names are not found in the original ideas, then the name
 * idea A idea B (the concatenation of idea A and idea B, separated by a space)
 * is a valid company name.
 * Otherwise, it is not a valid name.
 *
 * Return the number of distinct valid names for the company.
 *
 * Example 1:
 *
 * Input: ideas = ["coffee","donuts","time","toffee"] Output: 6 Explanation: The
 * following selections are valid: - ("coffee", "donuts"): The company name
 * created is "doffee conuts". - ("donuts", "coffee"): The company name created
 * is "conuts doffee". - ("donuts", "time"): The company name created is "tonuts
 * dime". - ("donuts", "toffee"): The company name created is "tonuts doffee". -
 * ("time", "donuts"): The company name created is "dime tonuts". - ("toffee",
 * "donuts"): The company name created is "doffee tonuts". Therefore, there are
 * a total of 6 distinct company names. The following are some examples of
 * invalid selections: - ("coffee", "time"): The name "toffee" formed after
 * swapping already exists in the original array. - ("time", "toffee"): Both
 * names are still the same after swapping and exist in the original array. -
 * ("coffee", "toffee"): Both names formed after swapping already exist in the
 * original array.
 *
 * Example 2:
 *
 * Input: ideas = ["lack","back"] Output: 0 Explanation: There are no valid
 * selections. Therefore, 0 is returned.
 *
 * Constraints:
 *
 * 2 <= ideas.length <= 5 * 10 4
 * 1 <= ideas[i].length <= 10
 * ideas[i] consists of lowercase English letters.
 * All the strings in ideas are unique.
 */
class Solution02306 {

  // Time Limit Exceeded
  // public long distinctNames(String[] ideas) {
  // long result = 0;
  // Set<String> set = new HashSet<>(Arrays.asList(ideas));
  // for (int i = 0; i < ideas.length; i++) {
  // for (int j = i + 1; j < ideas.length; j++) {
  // String ideaA = ideas[i];
  // String ideaB = ideas[j];
  // String newIdeaA = ideaB.charAt(0) + ideaA.substring(1);
  // String newIdeaB = ideaA.charAt(0) + ideaB.substring(1);
  // if (!set.contains(newIdeaA) && !set.contains(newIdeaB)) {
  // result++;
  // }
  // }
  // }
  // return result * 2;
  // }

  public long distinctNames(String[] ideas) {
    @SuppressWarnings("unchecked")
    Set<String>[] sets = new HashSet[26];
    for (int i = 0; i < 26; i++) {
      sets[i] = new HashSet<String>();
    }
    for (String s : ideas) {
      sets[s.charAt(0) - 'a'].add(s.substring(1));
    }
    int[][] same = new int[26][26];
    for (int i = 0; i < 26; i++) {
      for (String s : sets[i]) {
        for (int j = i + 1; j < 26; j++) {
          if (sets[j].contains(s)) {
            same[i][j]++;
          }
        }
      }
    }
    long res = 0;
    for (int i = 0; i < 26; i++) {
      for (int j = i + 1; j < 26; j++) {
        res += (sets[i].size() - same[i][j]) * (sets[j].size() - same[i][j]) * 2;
      }
    }
    return res;
  }

  public static void test_02306() {
    Solution02306 solution = new Solution02306();
    String[] ideas = { "coffee", "donuts", "time", "toffee" };
    long result = solution.distinctNames(ideas);
    System.out.println(result);
    String[] ideas2 = { "lack", "back" };
    result = solution.distinctNames(ideas2);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution02306.test_02306();
  }
}
