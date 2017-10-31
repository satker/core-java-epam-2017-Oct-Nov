package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestableTask1Impl implements ITestableTask1 {
    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> list = new ArrayList<>();

        try (FileReader reader = new FileReader(input)) {
            StringBuilder line = new StringBuilder();
            for(;;) {
                int ch = reader.read();
                if( ch == '\n' || ch == -1 ) {
                    list.add(line.toString());
                    line.setLength(0);
                    if (ch == -1) {
                        break;
                    }
                } else {
                    line.append(Character.toChars(ch));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try (FileWriter writer = new FileWriter(output)) {
            for(int i = list.size() - 1; i >= 0; --i) {
                writer.write(list.get(i));
                writer.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return list;
    }
}
