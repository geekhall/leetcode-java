package cn.geekhall.problems.p00000.p00093;

import java.util.ArrayList;
import java.util.List;

/**
 * ID:    00093
 * Title: Restore IP Addresses
 * Difficulty: Medium
 * Description: A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 *
 * Example 1:
 *
 * Input: s = "25525511135" Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 *
 * Input: s = "0000" Output: ["0.0.0.0"]
 *
 * Example 3:
 *
 * Input: s = "101023" Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 */
class Solution00093 {

  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    int len = s.length();
    for (int i = 1; i < 4 && i < len - 2; i++) {
      for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
        for (int k = j + 1; k < j + 4 && k < len; k++) {
          String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
          if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
          }
        }
      }
    }
    return res;
  }

  /**
   * Check if the string is a valid IP addresss
   * @param s1
   * @return
   */
  private boolean isValid(String s1) {
    if (s1.length() > 3 || (s1.startsWith("0") && s1.length() > 1) || Integer.parseInt(s1) > 255) {
      return false;
    }
    return true;
  }

  public static void test_00093() {
    Solution00093 solution = new Solution00093();
    String s = "25525511135";
    List<String> res = solution.restoreIpAddresses(s);
    System.out.println(res);
    String s2 = "0000";
    List<String> res2 = solution.restoreIpAddresses(s2);
    System.out.println(res2);
  }

  public static void main(String[] args) {
    Solution00093.test_00093();
  }
}

