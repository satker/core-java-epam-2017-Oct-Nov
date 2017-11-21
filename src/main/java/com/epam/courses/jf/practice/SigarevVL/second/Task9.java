package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.*;
import java.util.HashSet;

public class Task9 implements ITestableTask9 {
    @Override
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> resultSet = new HashSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for(String string : line.split(" ")){
                    resultSet.add(string.toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
