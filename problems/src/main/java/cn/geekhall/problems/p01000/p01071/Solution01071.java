package cn.geekhall.problems.p01000.p01071;

/**
 * ID: 01071
 * Title: Greatest Common Divisor of Strings
 * Difficulty: Easy
 * Description: For two strings s and t, we say " t divides s" if and only if s
 * = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x
 * divides both str1 and str2.
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC" Output:"ABC"
 *
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB" Output:"AB"
 *
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE" Output:""
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
class Solution01071 {

  public String gcdOfStrings(String str1, String str2) {
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }
    return str1.substring(0, gcd(str1.length(), str2.length()));
  }

  private int gcd(int length, int length2) {
    return length2 == 0 ? length : gcd(length2, length % length2);
  }

  public static void test_01071() {
    Solution01071 solution = new Solution01071();
    String str1 = "ABCABC";
    String str2 = "ABC";
    String result = solution.gcdOfStrings(str1, str2);
    System.out.println(result);
    String str3 = "ABABAB";
    String str4 = "ABAB";
    String result2 = solution.gcdOfStrings(str3, str4);
    System.out.println(result2);
    String str5 = "LEET";
    String str6 = "CODE";
    String result3 = solution.gcdOfStrings(str5, str6);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution01071.test_01071();
  }
}
