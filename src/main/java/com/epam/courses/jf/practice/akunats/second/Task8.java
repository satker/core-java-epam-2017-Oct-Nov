package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.Arrays;
import java.util.Stack;

public class Task8 implements ITestableTask8 {
    //  1 не подходит, требуется следующая итерация
    // 0 подходит
    // -1 не подходит полностью
    public int control(String a, String b) {
        int result = 1;
        for (int i = 0; i < a.length(); i++) {
            char previousElement = a.toCharArray()[i];
            char nowStr = b.toCharArray()[a.length() - 1 - i];
            if ((nowStr == '(' && previousElement == ')') ||
                    (nowStr == '[' && previousElement == ']') ||
                    (nowStr == '{' && previousElement == '}')) {
                result = 0;
            } else if (previousElement == '(' || previousElement == '{'
                    || previousElement == '[') {
                result = -1;
            }
        }
        return result;
    }

    public boolean isNormalBrackets(String string) {
        Stack<String> stackSymbols = new Stack<>();
        // убираем все элементы кроме скобок и записываемв стек
        Arrays.stream(string.replaceAll("[^\\[\\]\\(\\)\\{\\}]+", "").split(""))
                .forEach(stackSymbols::push);
        String previousElement = "";
        String nowStr = "";
        boolean result = true;
        int i = 0;
        while (stackSymbols.size() > 0) {
            if (i == 0) {
                String pop1 = stackSymbols.pop();
                previousElement = previousElement.concat(pop1);
                i++;
            } else if (i == 1) {
                String pop2 = stackSymbols.pop();
                nowStr = nowStr.concat(pop2);
                if (pop2.equals("(") || pop2.equals("{") || pop2.equals("[")){
                    if (control(previousElement, nowStr) == 0){
                            previousElement = "";
                            nowStr = "";
                            i = 0;
                    } else {
                        nowStr = nowStr.replaceAll("[(\\]\\[)|(\\)\\()|(\\}\\{)]", "");
                    }
                } else {
                    if (control(previousElement, nowStr) == (-1)) {
                        result = false;
                        break;
                    } else if (control(previousElement, nowStr) == 0) {
                        previousElement = "";
                        nowStr = "";
                        i = 0;
                    }
                }
            }
        }
        if (nowStr.length() != 0 || previousElement.length() != 0){
            result = false;
        }
        return result;
    }
}
