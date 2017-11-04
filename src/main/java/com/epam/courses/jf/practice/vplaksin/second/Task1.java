package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 implements ITestableTask1 {

    @Override
    public List<String> reverseFile(File input, File output) {

        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String s;
            while ((s = reader.readLine()) != null) {
                result.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (int i = result.size() - 1; i >= 0; i--) {
                writer.write(result.get(i));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
