package net.geekhour.problems.p00000.p00028;

/**
 * ID: 00028
 * Title: Find the Index of the First Occurrence in a String
 * Difficulty: Medium
 * Description: Given two strings needle and haystack, return the index of the
 * first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad" Output: 0 Explanation:"sad"
 * occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto" Output: -1 Explanation:"leeto"
 * did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 10 4
 * haystack and needle consist of only lowercase English characters.
 */
class Solution00028 {

  public int strStr(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();
    if (n == 0) {
      return 0;
    }
    if (m < n) {
      return -1;
    }
    for (int i = 0; i < m - n + 1; i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        int j = 1;
        for (; j < n; j++) {
          if (haystack.charAt(i + j) != needle.charAt(j)) {
            break;
          }
        }
        if (j == n) {
          return i;
        }
      }
    }
    return -1;
  }

  public static void test_00028() {
    Solution00028 solution = new Solution00028();
    String haystack = "sadbutsad";
    String needle = "sad";
    int result = solution.strStr(haystack, needle);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00028.test_00028();
  }
}
