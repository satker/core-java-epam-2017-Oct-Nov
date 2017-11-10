package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Task8Impl implements ITestableTask8 {

    static HashMap<Character, Integer> bracketRules;

    static {
        bracketRules = new HashMap<>();
        bracketRules.put('(', 0);
        bracketRules.put(')', 0);
        bracketRules.put('[', 1);
        bracketRules.put(']', 1);
        bracketRules.put('{', 2);
        bracketRules.put('}', 2);
    }

    @Override
    public boolean isNormalBrackets(String string) {
        char[] charString = string.toCharArray();
        Deque<Integer> braces = new ArrayDeque<>();

        for (char singleChar : charString) {
            if (singleChar == '[' || singleChar == '{' || singleChar == '(')
                braces.push(bracketRules.get(singleChar));

            if (singleChar == ']' || singleChar == ')' || singleChar == '}')
                if (!braces.isEmpty())
                    if (braces.peek().equals(bracketRules.get(singleChar)))
                        braces.pop();
                    else
                        return false;
                else
                    return false;
        }

        return braces.isEmpty();
    }
}
