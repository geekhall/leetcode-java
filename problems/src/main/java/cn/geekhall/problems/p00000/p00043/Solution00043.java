package cn.geekhall.problems.p00000.p00043;

import java.util.Arrays;

/**
 * ID:    00043
 * Title: Multiply Strings
 * Difficulty: Medium
 * Description: Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3" Output:"6"
 *
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456" Output:"56088"
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
class Solution00043 {

  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int m = num1.length(), n = num2.length();
    int[] ansArr = new int[m + n];

    // 从个位数开始，逐位相乘
    // 例如：123 * 456
    // ansArr 最后的结果为：
    // 0     1      2      3      4     5
    // ------------------------------------
    //                                 18(3*6)
    //                           15(3*5)
    //                    12(3*4)
    //                           12(2*6)
    //                    10(2*5)
    //             8(2*4)
    //                     6(1*6)
    //             5(1*5)
    //     4(1*4)
    // ------------------------------------
    // 0   4       13     28     27     18
    // ------------------------------------
    for (int i = m - 1; i >= 0; i--) {
      int x = num1.charAt(i) - '0';
      for (int j = n - 1; j >= 0; j--) {
        int y = num2.charAt(j) - '0';
        ansArr[i + j + 1] += x * y;
      }
    }
    System.out.println(Arrays.toString(ansArr));// [0, 4, 13, 28, 27, 18]
    for (int i = m + n - 1; i > 0; i--) {
      ansArr[i - 1] += ansArr[i] / 10; // 进位
      ansArr[i] %= 10;                 // 取余
    }
    System.out.println(Arrays.toString(ansArr)); // [0, 5, 6, 0, 8, 8]
    int index = ansArr[0] == 0 ? 1 : 0;
    StringBuilder ans = new StringBuilder();
    while (index < m + n) {
      ans.append(ansArr[index]);
      index++;
    }
    return ans.toString();
  }

  public static void test_00043() {
    Solution00043 solution = new Solution00043();
    System.out.println("=====================================");
    System.out.println(solution.multiply("123", "456"));
    System.out.println("=====================================");
    // System.out.println(solution.multiply("9133", "0")); // Expected: 0, not 0000
    // System.out.println("=====================================");
    // System.out.println(solution.multiply("0", "9133")); // Expected: 0, not 0000
    // System.out.println("=====================================");
  }

  public static void main(String[] args) {
    Solution00043.test_00043();
  }
}

