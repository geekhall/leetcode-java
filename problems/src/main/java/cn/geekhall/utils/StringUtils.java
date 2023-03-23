package cn.geekhall.utils;

import java.nio.charset.Charset;

public class StringUtils {

  /**
   * 截取字符串，避免最后一个字符被截断成半个中文字符。
   */
  public static String smartSubstr(String str, int max_length) {
    int length = 0;
    int pre_length = 0;
    for (int i = 0; i < str.length(); i++) {
      if (Character.toString(str.charAt(i)).getBytes(Charset.forName("GBK")).length == 2) {
        length += 2;
      } else {
        length += 1;
      }

      if (length > max_length) {
        // System.out.println(str.substring(0, i));
        return str.substring(0, pre_length);
      }
      pre_length = length;
    }
    return str;
  }

  public static void main(String[] args) {
    String testStr = "这11是1一段包含中文的字符串";
    System.out.println(smartSubstr(testStr, 14));
  }
}
