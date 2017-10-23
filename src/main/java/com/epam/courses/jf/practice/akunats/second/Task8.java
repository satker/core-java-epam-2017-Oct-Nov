package com.epam.courses.jf.practice.akunats.second;

import java.util.Arrays;
import java.util.Stack;

public class Task8 {
    public boolean isNormalBrackets(String string) {
        Stack<String> stackSymbols = new Stack<>();
        // убираем все элементы кроме скобок и записываемв стек
        Arrays.stream(string.replaceAll("[^\\[\\]\\(\\)\\{\\}]+", "").split(""))
                .forEach(stackSymbols::push);
        String previousElement = "";
        boolean result = true;
        int i = 0;
        while (stackSymbols.size() > 0) {
            if (i == 0) {
                previousElement = stackSymbols.pop();
                i++;
            } else if (i == 1) {
                String nowStr = stackSymbols.pop();
                if (!((nowStr.equals("(") && previousElement.equals(")")) ||
                        (nowStr.equals("[") && previousElement.equals("]")) ||
                        (nowStr.equals("{") && previousElement.equals("}")))) {
                    result = false;
                    break;
                } else {
                    i = 0;
                }
            }
        }
        return result;
    }
}
