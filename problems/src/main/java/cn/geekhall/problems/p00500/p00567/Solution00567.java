package cn.geekhall.problems.p00500.p00567;

/**
 * ID: 00567
 * Title: Permutation in String
 * Difficulty: Medium
 * Description: Given two strings s1 and s2, return true if s2 contains a
 * permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1 's permutations is the substring of
 * s2.
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo" Output: true Explanation: s2 contains one
 * permutation of s1 ("ba").
 *
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo" Output: false
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 10 4
 * s1 and s2 consist of lowercase English letters.
 */
class Solution00567 {

  public boolean checkInclusion(String s1, String s2) {
    int[] s1Count = new int[26];
    int[] s2Count = new int[26];
    int s1Len = s1.length();
    int s2Len = s2.length();
    if (s1Len > s2Len) {
      return false;
    }
    for (int i = 0; i < s1Len; i++) {
      s1Count[s1.charAt(i) - 'a']++;
      s2Count[s2.charAt(i) - 'a']++;
    }
    if (check(s1Count, s2Count)) {
      return true;
    }
    for (int i = s1Len; i < s2Len; i++) {
      s2Count[s2.charAt(i) - 'a']++;
      s2Count[s2.charAt(i - s1Len) - 'a']--;
      if (check(s1Count, s2Count)) {
        return true;
      }
    }
    return false;
  }

  private boolean check(int[] s1Count, int[] s2Count) {
    for (int i = 0; i < 26; i++) {
      if (s1Count[i] != s2Count[i]) {
        return false;
      }
    }
    return true;
  }

  public static void test_00567() {
    Solution00567 solution = new Solution00567();
    String s1 = "ab";
    String s2 = "eidbaooo";
    boolean result = solution.checkInclusion(s1, s2);
    System.out.println(result);
    String s3 = "ab";
    String s4 = "eidboaoo";
    boolean result2 = solution.checkInclusion(s3, s4);
    System.out.println(result2);
  }

  public static void main(String[] args) {
    Solution00567.test_00567();
  }
}
