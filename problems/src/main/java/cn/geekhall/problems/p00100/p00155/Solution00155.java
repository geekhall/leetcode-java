package cn.geekhall.problems.p00100.p00155;

import java.util.Vector;

/**
 * ID:    00155
 * Title: Min Stack
 * Difficulty: Medium
 * Description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Example 1:
 *
 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"] [[],[-2],[0],[-3],[],[],[],[]] Output [null,null,null,null,-3,null,0,-2] Explanation MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0); minStack.push(-3); minStack.getMin(); // return -3 minStack.pop(); minStack.top(); // return 0 minStack.getMin(); // return -2
 *
 * Constraints:
 *
 * -2 31 <= val <= 2 31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 10 4 calls will be made to push, pop, top, and getMin.
 */
class MinStack {

  int[] stack;
  int min;

  public MinStack() {
    stack = new int[0];
    min = Integer.MAX_VALUE;
  }

  public void push(int val) {
    int[] newStack = new int[stack.length + 1];
    System.arraycopy(stack, 0, newStack, 0, stack.length);
    newStack[stack.length] = val;
    stack = newStack;
    if (val < min) {
      min = val;
    }
  }

  public void pop() {
    int[] newStack = new int[stack.length - 1];
    System.arraycopy(stack, 0, newStack, 0, stack.length - 1);
    stack = newStack;
    min = Integer.MAX_VALUE;
    for (int i = 0; i < stack.length; i++) {
      if (stack[i] < min) {
        min = stack[i];
      }
    }
  }

  public int top() {
    return stack[stack.length - 1];
  }

  public int getMin() {
    return min;
  }


  public static void test_00155() {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top()); // return 0
    System.out.println(minStack.getMin()); // return -2
  }

  public static void main(String[] args) {
    test_00155();
  }
}

