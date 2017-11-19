package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task1 implements ITestableTask1{

    @Override
    public List<String> reverseFile(File input, File output) {

        List<String> strings = new ArrayList<>();
        String string;

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {

            while ((string = reader.readLine()) != null) {
                strings.add(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ListIterator<String> it = strings.listIterator(strings.size());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            while(it.hasPrevious()){
                writer.write(it.previous());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }
}
