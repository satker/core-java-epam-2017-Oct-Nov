package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Task8 implements ITestableTask8 {
    public boolean isNormalBrackets(String string) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char c : string.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }
            if ((c == ')' || c == '}' || c == ']') && stack.isEmpty()) {
                return false;
            }
            if ((c == ')' && stack.peekLast() == '(' )
                    || (c == '}'  && stack.peekLast() == '{' )
                    || (c == ']' && stack.peekLast() == '[' )) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
