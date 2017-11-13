package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task7 implements ITestableTask7{

    @Override
    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second){

        List<Integer> result = new ArrayList<>();

        int size1 = first.size();
        int size2 = second.size();
        int val1, val2;

        while(first.get(size1-1) == 0){
            size1--;
        }

        while(second.get(size2-1) == 0){
            size2--;
        }




        for(int j = 0; j < (size1 + size2 - 1); j++){
            result.add(0);
        }

        for(int j = 0; j < size1; j++){
            for(int k = 0; k < size2; k++){
                val1 = first.get(j);
                val2 = second.get(k);
//                System.out.println(j+k);
                result.set(j+k, val1*val2 + result.get(j+k));
//                System.out.println(result + "");
            }
        }
        return result;
    }

}
