package cn.geekhall.problems.p00100.p00150;

import java.util.Stack;

/**
 * ID:    00150
 * Title: Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Description: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 = (0 + 17) + 5 = 17 + 5 = 22
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 10 4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
class Solution00150 {

  public int evalRPN(String[] tokens) {
    int n = tokens.length;
    int[] stack = new int[n];
    int top = -1;
    for (int i = 0; i < n; i++) {
      String token = tokens[i];
      if (token.equals("+")) {
        int a = stack[top--];
        int b = stack[top--];
        stack[++top] = b + a;
      } else if (token.equals("-")) {
        int a = stack[top--];
        int b = stack[top--];
        stack[++top] = b - a;
      } else if (token.equals("*")) {
        int a = stack[top--];
        int b = stack[top--];
        stack[++top] = b * a;
      } else if (token.equals("/")) {
        int a = stack[top--];
        int b = stack[top--];
        stack[++top] = b / a;
      } else {
        stack[++top] = Integer.parseInt(token);
      }
    }
    return stack[top];
  }

  public static void test_00150() {
    Solution00150 solution = new Solution00150();
    String[] tokens = {"2","1","+","3","*"};
    int result = solution.evalRPN(tokens);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00150.test_00150();
  }
}

