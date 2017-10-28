package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Task16 implements ITestableTask16, Comparator<Double> {
    public static void main(String[] args) {
        Task16 task = new Task16();

        I2DPoint centerPoint = new Point(3.0, 2.0);
        File outputFile = new File("D:\test.txt");

        task.analyze(centerPoint, 4, outputFile);
    }

    @Override
    public int compare(Double o1, Double o2) {
        return o1.compareTo(o2);
    }

    @Override
    public IFileWithPoints analyze(I2DPoint center, int radius, File output) {
        TreeMap<I2DPoint, Double> result = new TreeMap<>();
        double x0 = center.getX();
        double y0 = center.getY();
        for (int i = (int) (x0 - (radius - 1)); i < (int) (x0 + radius); i++) {
            for (int j = (int) (y0 - (radius - 1)); j < (int) (y0 + radius); j++) {
                if (i != (int) x0 && j != (int) y0) {
                    int A = Math.abs(i) - Math.abs((int) x0);
                    int B = Math.abs(j) - Math.abs((int) y0);
                    double length = Math.sqrt((A * A) + (B * B));
                    if (length < radius) {
                        result.put(new Point(i, j), length);
                    }
                }
            }
        }
        return new FileWithPoints(result, output);
    }

    class FileWithPoints implements IFileWithPoints {
        private File file;
        SortedMap<I2DPoint, Double> map;

        FileWithPoints(SortedMap<I2DPoint, Double> map, File file) {
            this.map = map;
            this.file = file;
            try (ObjectOutput output = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(file)))) {
                output.writeObject(map);
            } catch (IOException e) {
                System.out.println("Error write file.");
            }
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public SortedMap<I2DPoint, Double> getPoints() {
            try {
                List<String> returnMap = Files.lines(Paths.get(file.getPath()), Charset.forName("ISO-8859-1"))
                        .collect(Collectors.toList());
                return (SortedMap<I2DPoint, Double>) returnMap;
            } catch (IOException e) {
                System.out.println("Error read file");
                return null;
            }
        }
    }
}
