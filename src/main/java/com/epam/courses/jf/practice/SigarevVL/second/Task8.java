package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Task8 implements ITestableTask8{

    @Override
    public boolean isNormalBrackets(String string) {

        char inputString[] = string.toCharArray();
        Deque<Character> brackets = new ArrayDeque<>();

        for (int i = 0; i < inputString.length; i++) {
            switch (inputString[i]) {
                case '(':
                    brackets.push(inputString[i]);
                    break;
                case ')':
                    if (!brackets.isEmpty() && brackets.peek().equals('(')) {
                        brackets.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    brackets.push(inputString[i]);
                    break;
                case ']':
                    if (!brackets.isEmpty() && brackets.peek().equals('[')) {
                        brackets.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    brackets.push(inputString[i]);
                    break;
                case '}':
                    if (!brackets.isEmpty() && brackets.peek().equals('{')) {
                        brackets.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return brackets.isEmpty();
    }
}
