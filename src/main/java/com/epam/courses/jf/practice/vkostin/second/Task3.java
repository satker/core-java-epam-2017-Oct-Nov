package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.*;

public class Task3 implements ITestableTask3 {

    /*
    public static void main(String[] args) {

        List<String> lines1 = new ArrayList<>();
        lines1.add("1 string11");
        lines1.add("2 string2222");
        lines1.add("3 string333333");

        List<String> lines2 = new ArrayList<>();
        lines2.add("Primero");
        lines2.add("Segundo");
        lines2.add("Tercero");

        List<String> lines3 = new ArrayList<>();
        lines3.add("One1");
        lines3.add("Two22");
        lines3.add("Three333");

        IPoem poem1 = new Poem("Vova", lines1);
        IPoem poem2 = new Poem("Sasha", lines2);
        IPoem poem3 = new Poem("Vova", lines3);

        Task3 task = new Task3();

        Set<IPoem> poems = new HashSet<>();
        poems.add(poem1);
        poems.add(poem2);
        poems.add(poem3);

        System.out.println(task.sortPoems(poems, "Vova"));
    }
    */

    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> authorPoems = new ArrayList<>();
        for (IPoem poem : poems){
            if (poem.getAuthor().equals(author)){
                authorPoems.addAll(poem.getLines());
            }
        }
        authorPoems.sort(Comparator.comparingInt(String::length));
        return authorPoems;
    }


    static class Poem implements IPoem {

        String author;
        List<String> lines;

        Poem(String author, List<String> lines) {
            this.author = author;
            this.lines = lines;
        }

        @Override
        public List<String> getLines() {
            return lines;
        }

        @Override
        public String getAuthor() {
            return author;
        }
    }
}
