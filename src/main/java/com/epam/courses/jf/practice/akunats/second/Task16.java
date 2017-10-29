package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Task16 implements ITestableTask16 {

    public Double comp(I2DPoint o, I2DPoint centre){
        double A = Math.abs(o.getX()) - Math.abs(centre.getX());
        double B = Math.abs(o.getY()) - Math.abs(centre.getY());
        return Math.sqrt((A * A) + (B * B));
    }
    @Override
    public IFileWithPoints analyze(I2DPoint center, int radius, File output) {
        SortedMap<I2DPoint, Double> result = new TreeMap<>(Comparator.comparing(o -> comp(o, center)));
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