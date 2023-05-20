package net.geekhour.problems.p00900.p00926;

/**
 * ID: 00926
 * Title: Flip String to Monotone Increasing
 * Difficulty: Medium
 * Description: A binary string is monotone increasing if it consists of some
 * number of 0 's (possibly none), followed by some number of 1 's (also
 * possibly none).
 *
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or
 * from 1 to 0.
 *
 * Return the minimum number of flips to make s monotone increasing.
 *
 * Example 1:
 *
 * Input: s = "00110" Output: 1 Explanation: We flip the last digit to get
 * 00111.
 *
 * Example 2:
 *
 * Input: s = "010110" Output: 2 Explanation: We flip to get 011111, or
 * alternatively 000111.
 *
 * Example 3:
 *
 * Input: s = "00011000" Output: 2 Explanation: We flip to get 00000000.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 5
 * s[i] is either '0' or '1'.
 */
class Solution00926 {

  public int minFlipsMonoIncr(String s) {
    // Initialize variables to store the minimum number of flips and the number of
    // flips currently needed
    int ans = 0, noOfFlip = 0;

    // Iterate through each character in the input string
    for (int i = 0; i < s.length(); i++) {
      // If the current character is a '0', update the minimum number of flips and add
      // 1 to the current number of flips
      if (s.charAt(i) == '0')
        ans = Math.min(noOfFlip, ans + 1);
      // If the current character is a '1', increment the number of flips
      else
        noOfFlip++;
    }
    // Return the minimum number of flips
    return ans;
  }

  public static void test_00926() {
    Solution00926 solution = new Solution00926();
    String s = "00110";
    int res = solution.minFlipsMonoIncr(s);
    System.out.println(res);
    String s2 = "010110";
    int res2 = solution.minFlipsMonoIncr(s2);
    System.out.println(res2);
    String s3 = "00011000";
    int res3 = solution.minFlipsMonoIncr(s3);
    System.out.println(res3);

  }

  public static void main(String[] args) {
    Solution00926.test_00926();
  }
}
