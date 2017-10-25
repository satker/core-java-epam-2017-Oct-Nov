package com.epam.courses.jf.practice.common.first;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class SolverTest {
    @Test
    public void task1() throws Exception {
        String inputData = "4\nУнылая пора! Очей очарованье!\nПриятна мне твоя прощальная краса —\nЛюблю я пышное природы увяданье,\nВ багрец и в золото одетые леса,";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task1();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task2() throws Exception {
        String inputData = "5\nТихо струится река серебристая\nТкхо струится река серебристая\nВ царстве вечернем зеленой весны.\nСолнце садится" +
                " за горы лесистые.\nРог золотой выплывает луны.\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task2();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task3() throws Exception {
        String inputData = "5\nПослушайте!\nВедь, если звезды зажигают -\nзначит - это кому-нибудь нужно?\nЗначит - " +
                "кто-то хочет, чтобы они были?\nЗначит - кто-то называет эти плевочки жемчужиной?\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task3();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task4() throws Exception {
        String inputData = "4\nCake is a lie\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task4();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task5() throws Exception{
        String inputData = "5\nЯзык программирования Java is widespread\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task5();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task6() throws Exception{
        String inputData = "12\nThe original and reference implementation Java compilers were originally released by Sun\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task6();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task7() throws Exception{
        String inputData = "11\nThe Java programming language is a general-purpose, concurrent, class-based, object-oriented language\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task7();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task8() throws Exception{
        String inputData = "15\nChapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task8();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task9() throws Exception{
        String inputData = "5\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task9();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task10() throws Exception{
        String inputData = "2 7 0\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task10();
        } finally {
            System.setIn(oldSystemStream);
        }
    }

    @Test
    public void task11() throws Exception{
        String inputData = "1\n";
        InputStream inputDataStream = new ByteArrayInputStream(inputData.getBytes("UTF-8"));
        InputStream oldSystemStream = System.in;
        try {
            System.setIn(inputDataStream);
            Solver solver = new Solver();
            solver.task11();
        } finally {
            System.setIn(oldSystemStream);
        }
    }
}