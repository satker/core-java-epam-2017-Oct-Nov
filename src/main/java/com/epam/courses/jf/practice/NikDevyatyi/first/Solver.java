package com.epam.courses.jf.practice.NikDevyatyi.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.stream.IntStream;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class Solver implements ISolver {
    @Override
    public void task1() {

        String tempSmall ="";
        String tempBig ="";
        Scanner scanner = new Scanner(System.in);
        String[] strings = getStrings(scanner);
        tempSmall = strings[0];
        tempBig = strings[0];
        for (String str: strings){

            if(str.length()<= tempSmall.length()){
                tempSmall = str;
            }
            if(str.length()>= tempBig.length()){
                tempBig = str;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", tempSmall.length(), tempSmall);
        System.out.printf("MAX (%d): \"%s\"%n", tempBig.length(), tempBig);


    }
    @Override
    public void task2() {
        Scanner sc = new Scanner(System.in);
        String arrStr [] = getStrings(sc);
        Arrays.sort(arrStr,Comparator.comparingInt(String::length)
                .thenComparing(String::compareTo));

        for(String str: arrStr){
            System.out.printf("(%d):\"%s\"%n", str.length(), str);

        }

    }

    /***

     * @param scanner
     * @return String[]
     * <p>getStrings() method to get Strins from System.in()</p>
     */
    private String[] getStrings(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        return strings;
    }
    private String[] getStrings2(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        String[] strings = new String[n];
        strings = scanner.nextLine().split(" ");
        return strings;
    }
    @Override
    public void task3() {
        int summ = 0;
        Scanner sc = new Scanner(System.in);
        String arrStr[] = getStrings(sc);

        for (String str : arrStr) {
            summ+= str.length();
        }
        System.out.printf("AVERAGE (%d)%n", summ/arrStr.length);

        for (String str : arrStr){
            if (str.length() < summ/arrStr.length){
                System.out.printf("(%d):\"%s\"%n",str.length(),str);
            }
        }
    }
    @Override
    public  void task4(){
        Scanner sc = new Scanner(System.in);
        String[] s = getStrings2(sc);
        String result = s[0];
        int checkRepeat = checkLetterRepeat(s[0]);

        for(String word: s){
            if(word.length() == 1){
                result= word;
                break;
            }

            else if(checkRepeat > checkLetterRepeat(word)  ){
                result = word;
                checkRepeat = checkLetterRepeat(word);
            }

        }
        System.out.println(result);
    }

    /***

     * @param nameString
     * @return int
     *<p> checkLetterRepeat method to counting how many times letters repeated in word for task5()</p>
     */
    private static int checkLetterRepeat(String nameString){
        int result= 0;
        char[] symbols = nameString.toCharArray();

        int maxChar = (int)symbols[0];
        for(char c : symbols) {
            if (maxChar < (int)c) {
                maxChar = (int)c;
            }
        }
        int[] code = new int[maxChar+1];
        Arrays.fill(code, 0);
        for (char m : symbols) {
            code[m]++;
        }
        for(int item : code){
            if(item > 1){
                result+= item;
            }
        }
        return result;

    }
    @Override
    public  void task5(){
        Scanner sc = new Scanner(System.in);
        String[] arrStr = getStrings2(sc);

        int vowelsInWord = 0;
        int counter =0;
        for(String word: arrStr){
            if(word.length() % 2 == 0 && word.matches("[a-zA-Z]+")){
                for(char c : word.toLowerCase().toCharArray()){
                    if(Character.toString(c).matches("[aeiouy]")){
                        vowelsInWord++;
                    }
                }

                if(word.length()/2 == vowelsInWord){
                    counter++;
                }
                vowelsInWord = 0;
            }
        }
        System.out.println(counter);
    }

}
