package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.Stack;

public class Task8 implements ITestableTask8 {

    /*
    public static void main(String[] args) {
        String exampleString = "({[]}[(){()()}])";

        Task8 task = new Task8();
        System.out.println(task.isNormalBrackets(exampleString));
    }
    */

    @Override
    public boolean isNormalBrackets(String string) {

        char[] brackets = string.toCharArray();
        Stack<Character> stack = new Stack<>();

        char lastLiteral = brackets[0];
        stack.push(lastLiteral);

        char currentLiteral;

        for (int i = 1; i < brackets.length; ++i) {
            currentLiteral = brackets[i];
            stack.push(currentLiteral);

            // (int) '[' = (int) ']' + 2 -- the same for "{}"
            // (int) '(' = (int) ')' + 1
            if ((((int) currentLiteral - 2) == lastLiteral)
                    || (((int) currentLiteral - 1) == lastLiteral)) {
                stack.pop();
                stack.pop();
                if (!stack.empty()) {
                    lastLiteral = stack.peek();
                }
            } else {
                lastLiteral = currentLiteral;
            }
        }

        return stack.empty();
    }
}
