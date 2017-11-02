package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by asus on 26.10.2017.
 */
public class ITestableTask8Impl implements ITestableTask8 {
    @Override
    public boolean isNormalBrackets(String string) {
        Deque<Character> deque = new ArrayDeque<>();

        for (Character character : string.toCharArray()) {
            if (character.equals('[') || character.equals('{') || character.equals('(')) {
                deque.push(character);
                continue;
            } else if (character.equals(')') && (deque.isEmpty() || deque.peek() != '(')) {
                return false;
            } else if (character.equals('}') && (deque.isEmpty() || deque.peek() != '{')) {
                return false;
            } else if (character.equals(']') && (deque.isEmpty() || deque.peek() != '[')) {
                return false;
            }
            if (character.equals(')') || character.equals('}') || character.equals(']')) {
                deque.poll();
            }
        }

        if (deque.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
