package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by asus on 24.10.2017.
 * TODO: Done!
 */

public class ITestableTask9Impl implements ITestableTask9 {
    @Override
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> result = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            while (reader.ready()) {
                result.addAll(Arrays.asList(reader.readLine().toLowerCase().split(" ")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
