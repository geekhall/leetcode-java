package cn.geekhall.datastructures.stack;

import java.util.Stack;

public class ReverseStackSample {
    /**
     * reverse stack by recursive.
     * @param stack stack to be reversed.
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int res = f(stack);
        reverse(stack);
        stack.push(res);
    }

    /**
     * 1) pop the top element and return.
     * 2) reverse the remaining elements.
     *
     * @param stack input stack.
     * @return  reversed stack without top element.
     */
    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }

    }
}
