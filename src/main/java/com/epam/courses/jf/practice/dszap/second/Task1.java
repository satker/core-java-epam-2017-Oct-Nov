package com.epam.courses.jf.practice.dszap.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.*;

public class Task1 implements ITestableTask1 {

    @Override
    public List<String> reverseFile(File input, File output) {
        LinkedList<String> result = new LinkedList<>();
        try (Scanner in = new Scanner(input);
             BufferedWriter out = new BufferedWriter(new FileWriter(output))) {
            while (in.hasNextLine()) {
                result.add(in.nextLine());
            }
            Iterator<String> iterator = result.descendingIterator();
            while (iterator.hasNext()) {
                out.write(iterator.next() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
