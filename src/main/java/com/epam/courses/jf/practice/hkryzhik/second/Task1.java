package com.epam.courses.jf.practice.hkryzhik.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 implements ITestableTask1{
    @Override
    public List<String> reverseFile(File input, File output) {

        if(input.canRead() && input.exists()){
            List<String> inputStringList = new ArrayList<>();
            try {
                char[] inputLineBuffer = new char[(int)input.length()];

                InputStreamReader fileReader = new InputStreamReader(new FileInputStream(input));

                fileReader.read(inputLineBuffer);

                String[] inputStringArray = new String(inputLineBuffer).split(" ");

                inputStringList.addAll(Arrays.asList(inputStringArray));

                OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream(output));

                for (int i = inputStringList.size() - 1; i != 0; i--) {
                    fileWriter.write(inputStringList.get(i));
                    fileWriter.write(", ");
                }

                fileWriter.close();
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            return inputStringList;
        }else {
            return null;
        }
    }
}
