package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.Stack;

public class Task8 implements ITestableTask8 {

    @Override
    public boolean isNormalBrackets(String string) {

        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (stack.empty()) {
                    return false;
                } else {
                    char checkChar = stack.pop();
                    if (!(checkChar == '{' && c == '}'
                            || checkChar == '(' && c == ')'
                            || checkChar == '[' && c == ']')) {
                        return false;
                    }
                }
            }
        }

        return stack.empty();

    }

}
