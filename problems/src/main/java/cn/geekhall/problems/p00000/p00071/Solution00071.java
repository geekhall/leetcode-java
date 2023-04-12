package cn.geekhall.problems.p00000.p00071;

import java.util.*;

/**
 * ID: 00071
 * Title: Simplify Path
 * Difficulty: Medium
 * Description: Given a string path, which is an absolute path (starting with a
 * slash '/') to a file or directory in a Unix-style file system, convert it to
 * the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a
 * double period '..' refers to the directory up a level, and any multiple
 * consecutive slashes (i.e. '//') are treated as a single slash '/'. For this
 * problem, any other format of periods such as '...' are treated as
 * file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to
 * the target file or directory (i.e., no period '.' or double period '..')
 *
 * Return the simplified canonical path.
 *
 * Example 1:
 *
 * Input: path = "/home/" Output:"/home" Explanation: Note that there is no
 * trailing slash after the last directory name.
 *
 * Example 2:
 *
 * Input: path = "/../" Output:"/" Explanation: Going one level up from the root
 * directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 *
 * Input: path = "/home//foo/" Output:"/home/foo" Explanation: In the canonical
 * path, multiple consecutive slashes are replaced by a single one.
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
class Solution00071 {

  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] paths = path.split("/");
    for (String p : paths) {
      if (p.equals(".") || p.equals("")) {
        continue;
      } else if (p.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(p);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
      sb.insert(0, "/");
    }
    if (sb.length() == 0) {
      sb.append("/");
    }
    return sb.toString();
  }

  public static void test_00071() {
    Solution00071 solution = new Solution00071();
    String path = "/home/";
    String result = solution.simplifyPath(path);
    System.out.println(result);
    String path2 = "/../";
    String result2 = solution.simplifyPath(path2);
    System.out.println(result2);
    String path3 = "/home//foo/";
    String result3 = solution.simplifyPath(path3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution00071.test_00071();
  }
}
