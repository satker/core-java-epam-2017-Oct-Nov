package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Task11 implements ITestableTask11 {

    /*
    public static void main(String[] args) {
        Task11 task = new Task11();

//        ArrayList<String> names = new ArrayList<>();
        LinkedList<String> names = new LinkedList<>();

        names.add("Vova");
        names.add("Wilder");
        names.add("Ramona");
        names.add("Kevin");
        names.add("Sasha");
        names.add("Dima");

        System.out.println(task.emulate(names));
    }
    */

    @Override
    public String emulate(ArrayList<String> peoples) {

        while (true) {
            if (1 == peoples.size()) {
                return peoples.get(0);
            } else {
                // ++i simply because after each deleted element the size of the array decreases
                // so each "+1" is actually "+2"
                if (peoples.size() % 2 != 0) {
                    String wantToDoCircle = peoples.get(peoples.size() - 1);
                    for (int i = 0; i < peoples.size(); ++i) {
                        peoples.remove(i);
                    }
                    peoples.add(0, wantToDoCircle);
                } else {
                    for (int i = 0; i < peoples.size(); ++i) {
                        peoples.remove(i);
                    }
                }
            }
        }
    }

    @Override
    public String emulate(LinkedList<String> peoples) {

        int counter = 0;

        while (peoples.size() > 1) {
            ListIterator iter = peoples.listIterator();
            while (iter.hasNext()) {
                iter.next();
                if (counter % 2 == 0) {
                    iter.remove();
                }
                ++counter;
            }
        }
        return peoples.getFirst();
    }
}
