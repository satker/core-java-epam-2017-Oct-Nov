package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.util.*;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task8 implements ITestableTask8{


    Map<Character, Character> bracketsMap = new HashMap<>();
    List<Character> bracketsList = new ArrayList<>();
    Map<Character, Character> closedBracketsMap = new HashMap<>();

    public void createClosedBracketsMap(){
        closedBracketsMap.put(')','(');
        closedBracketsMap.put('}','{');
        closedBracketsMap.put(']','[');
    }

    public void createBracketsMap(){
        bracketsMap.put('{','}');
        bracketsMap.put('[',']');
        bracketsMap.put('(',')');
        bracketsMap.put('}','{');
        bracketsMap.put(']','[');
        bracketsMap.put(')','(');
    }

    public void stringToBracketsArray(String string){
        Set<Character> keySet = bracketsMap.keySet();
        for(Character ch: string.toCharArray()){
            if(keySet.contains(ch)){
                bracketsList.add(ch);
            }
        }
    }

    @Override
    public boolean isNormalBrackets(String string) {
        createBracketsMap();
        createClosedBracketsMap();
        stringToBracketsArray(string);
        Character temp;
        Stack<Character> stack = new Stack<>();
        stack.push('0');
        for(Character bracket: bracketsList){
            if(closedBracketsMap.keySet().contains(bracket)){
                temp = stack.peek();
                if(bracket.equals(bracketsMap.get(temp))){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(bracket);
            }
        }
        if(!stack.peek().equals('0')){
            return false;
        }
        return true;
    }
}
