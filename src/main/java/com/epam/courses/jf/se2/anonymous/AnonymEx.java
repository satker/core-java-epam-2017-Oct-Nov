package com.epam.courses.jf.se2.anonymous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Date;

public class AnonymEx {


    public static void main(String[] args) {
        Date d = new Date(){

            private int value = 5;

            @Override
            public String toString(){
                return "new version toString method" + value;
            }
        };
        Date another = new Date(){

            private int value = 5;

            @Override
            public String toString(){
                return "new version toString method" + value;
            }
        };

        Comparator<Date> dateComparator = new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return 0;
            }
        };
        System.out.println(d);
        System.out.println(d.getClass().getName());
        System.out.println(another.getClass().getName());

        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comparator<Date> dateComparator = new Comparator<Date>() {
                    @Override
                    public int compare(Date o1, Date o2) {
                        return 0;
                    }
                };
            }
        });
    }

}

