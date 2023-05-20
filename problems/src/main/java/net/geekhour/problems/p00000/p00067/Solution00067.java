package net.geekhour.problems.p00000.p00067;

/**
 * ID: 00067
 * Title: Add Binary
 * Difficulty: Easy
 * Description: Given two binary strings a and b, return their sum as a binary
 * string.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1" Output:"100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011" Output:"10101"
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 10 4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
class Solution00067 {

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int ca = 0;
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
      int sum = ca;
      sum += i >= 0 ? a.charAt(i) - '0' : 0;
      sum += j >= 0 ? b.charAt(j) - '0' : 0;
      sb.append(sum % 2);
      ca = sum / 2;
    }
    sb.append(ca == 1 ? ca : "");
    return sb.reverse().toString();
  }

  public static void test_00067() {
    Solution00067 solution = new Solution00067();
    String a = "101";
    String b = "110";
    String result = solution.addBinary(a, b);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00067.test_00067();
  }
}
