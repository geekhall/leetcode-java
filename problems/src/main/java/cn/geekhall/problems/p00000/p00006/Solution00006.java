package cn.geekhall.problems.p00000.p00006;

/**
 * ID: 00006
 * Title: Zigzag Conversion
 * Difficulty: Medium
 * Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a
 * given number of rows like this: (you may want to display this pattern in a
 * fixed font for better legibility)
 *
 * P A H N A P L S I I G Y I R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3 Output:"PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4 Output:"PINALSIGYAHRPI" Explanation:
 * P I N A L S I G Y A H R P I
 *
 * Example 3:
 *
 * Input: s = "A", numRows = 1 Output:"A"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
class Solution00006 {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int len = s.length();
    int cycleLen = 2 * numRows - 2; // 一个周期的长度
    StringBuilder sb = new StringBuilder();
    // 从第一行开始，每一行的字符都是一个周期的字符
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j + i < len; j += cycleLen) {
        sb.append(s.charAt(j + i));
        if (i != 0 && i != numRows - 1 && j + cycleLen - i < len) {
          sb.append(s.charAt(j + cycleLen - i));
        }
      }
    }
    return sb.toString();
  }

  public static void test_00006() {
    Solution00006 solution = new Solution00006();
    String s = "PAYPALISHIRING";
    int numRows = 3;
    String result = solution.convert(s, numRows);
    System.out.println(result);
    String s2 = "PAYPALISHIRING";
    int numRows2 = 4;
    String result2 = solution.convert(s2, numRows2);
    System.out.println(result2);
    String s3 = "A";
    int numRows3 = 1;
    String result3 = solution.convert(s3, numRows3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution00006.test_00006();
  }
}
