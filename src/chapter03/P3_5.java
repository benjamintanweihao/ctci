package chapter03;

import java.util.Arrays;
import java.util.Stack;

class P3_5 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(6);
        stack.push(4);
        stack.push(5);
        stack.push(9);
        stack.push(3);
        stack.push(9);

        System.out.println(Arrays.toString(stack.toArray()));
        Stack<Integer> sorted = sortStack(stack);
        System.out.println(Arrays.toString(sorted.toArray()));
    }

    private static Stack<Integer> sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        int pushed;
        int min;

        while (!s1.isEmpty()) {
            min = Integer.MAX_VALUE;
            pushed = s1.size();

            while (!s1.isEmpty()) {
                int value = s1.pop();
                if (value < min) {
                    min = value;
                }
                s2.push(value);
            }

            int count = 0;
            while (pushed-- > 0) {
                int value = s2.pop();
                if (value == min) {
                    count++;
                } else {
                    s1.push(value);
                }
            }

            while (count-- > 0) {
                s2.push(min);
            }
        }

        return s2;
    }
}
