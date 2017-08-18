package com.epam.courses.jf.se4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Streams {


    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    }


    private static void writeToFile() throws IOException {
        byte[] bytesToWrite = { 1, 2, 3 };
        byte[] bytesReaded = new byte[10];
        String fileName = "d:\\test.txt";
        FileOutputStream outFile = null;
        FileInputStream inFile = null;

        outFile = new FileOutputStream(fileName);
        System.out.println("Файл открыт для записи");
        outFile.write(bytesToWrite);
        System.out.println("Записано: " + bytesToWrite.length + " байт");
        outFile.close();
        System.out.println("Выходной поток закрыт");

        inFile = new FileInputStream(fileName);
        System.out.println("Файл открыт для чтения");
        int bytesAvailable = inFile.available();
        System.out.println("Готово к считыванию: " + bytesAvailable + " байт");
        int count = inFile.read(bytesReaded, 0, bytesAvailable);
        System.out.println("Считано: " + count + " байт");
        inFile.close();
        System.out.println("Входной поток закрыт");
    }

    private static void pipedStreams() throws IOException {
        PipedInputStream pipeIn = new PipedInputStream();
        PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);

        for (int i = 0; i < 20; i++) {
            pipeOut.write(i);
        }
        int[] toRead = new int[pipeIn.available()];

        for (int i = 0; i < toRead.length; ++i) {
            toRead[i] = pipeIn.read();
            System.out.print(toRead[i] + " ");
        }
    }

    private static void fileStreams() throws IOException {
        FileInputStream inFile1 = new FileInputStream("file 1.txt");
        FileInputStream inFile2 = new FileInputStream("file 2.txt");
        SequenceInputStream sequenceStream = new SequenceInputStream(inFile1, inFile2);
        FileOutputStream outFile = new FileOutputStream("file 3.txt");

        int readedByte = sequenceStream.read();
        while (readedByte != -1) {
            outFile.write(readedByte);
            readedByte = sequenceStream.read();
        }
    }

    private static void charArrayReader() throws IOException {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        int length = tmp.length();
        char c[] = new char[length];

        tmp.getChars(0, length, c, 0);
        CharArrayReader input1 = new CharArrayReader(c);
        CharArrayReader input2 = new CharArrayReader(c, 0, 5);
        int i;

        System.out.println("input1 is:");
        while ((i = input1.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
        System.out.println("input2 is:");
        while ((i = input2.read()) != -1) {
            System.out.print((char) i);
        }
    }


    private static void pushBackReader() throws IOException {
        char buf[] = "if (a == 4) a = 0;\n".toCharArray();
        PushbackReader f = new PushbackReader(new CharArrayReader(buf));
        int c;

        while ((c = f.read()) != -1) {
            switch (c) {
                case '=':
                    if ((c = f.read()) == '=')
                        System.out.print(".eq.");
                    else {
                        System.out.print("<-");
                        f.unread(c);
                    }
                    break;
                default:
                    System.out.print((char) c);
                    break;
            }
        }
    }

    private static void readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("FileReaderExample.java"))) {
            for (String current = reader.readLine(); current != null; current = reader.readLine()) {
                System.out.println(current);
            }
        }

        Files.readAllLines(Paths.get("FileReaderExample.java"))
             .forEach(System.out::println);
    }

    private static void usingScanner() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("tmp.txt");
        Scanner scanner = new Scanner(file);
        Scanner scannerOther = new Scanner(file);

        System.out.println(scanner.nextLine().equals(scannerOther.nextLine()));
    }
}
