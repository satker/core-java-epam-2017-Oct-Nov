package com.epam.courses.jf.practice.hkryzhik.first;


import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solver implements ISolver {

    static int index;

    private static boolean isSorted(char[] characters){

        for(int i = 1; i < characters.length; i++) {

            if(characters[i - 1] > characters[i]) {

                return false;
            }
        }
        return true;
    }

    @Override
    public void task1() {

        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<String> inputStringList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            inputStringList.add(inputData.nextLine());
        }

        inputStringList.sort((s1, s2) -> s1.length() - s2.length());

        System.out.println("MIN (" + inputStringList.get(0).length() + "): \"" +  inputStringList.get(0) + "\"");
        System.out.println("MAX (" + inputStringList.get(inputStringList.size() - 1).length() +
                "): \"" +  inputStringList.get(inputStringList.size() - 1) + "\"");
    }

    @Override
    public void task2() {

        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<String> inputStringList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            inputStringList.add(inputData.nextLine());
        }

        inputStringList.sort((String s1, String s2) -> {
            if(s1.equals(s2)){
                return 0;
            }else {
                if(s1.length() != s2.length()){
                    return s1.length() - s2.length();
                }else{
                    for (int i = 0; i < s1.length(); i++) {
                        if((int)s1.charAt(i) > (int)s2.charAt(i)){
                            return -1;
                        }else {
                            return 1;
                        }
                    }
                    return 0;
                }
            }
        });

        for (String string: inputStringList) {
            System.out.printf("%d: \"%s\"\n", string.length(), string);
        }

    }

    @Override
    public void task3() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;
        int length = 0;


        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<String> inputStringList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            inputStringList.add(inputData.nextLine());
        }

        for (String string : inputStringList) {
            length += string.length();
        }

        final int stringLength = length / size;

        System.out.println("AVERAGE(" + stringLength + ")");

        inputStringList.forEach((String s) ->{

            if(s.length() < stringLength){
                System.out.printf("(%d): \"%s\"\n", s.length(), s);
            }

        });

    }

    @Override
    public void task4() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        String[] inputStrings = inputData.nextLine().split(" ");

        ArrayList<HashSet> sets = new ArrayList<>();

        for(String str : inputStrings){
            HashSet<Character> characterSet = new HashSet<>();
            for (Character ch : str.toLowerCase().toCharArray()) {
                characterSet.add(ch);
            }
            sets.add(characterSet);
        }

        System.out.println(inputStrings[sets.indexOf(sets.stream().min((ch1, ch2) -> ch1.size() - ch2.size()).get())]);

    }

    @Override
    public void task5() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        String[] inputStrings = inputData.nextLine().split(" ");

        int count = 0;

        for (String string : inputStrings) {

            String lowerCaseString = string.toLowerCase();

            if(lowerCaseString.matches("([a-z])\\w+")){

                Pattern vowels = Pattern.compile("([aeiouy])");
                Pattern consonants = Pattern.compile("([bcdfghjklmnpqrstvwxz])");

                Matcher vowelsMatcher = vowels.matcher(lowerCaseString);
                Matcher consonantsMatcher = consonants.matcher(lowerCaseString);
                int vowelsCount = 0;
                int consonantsCount = 0;
                while (vowelsMatcher.find()) {
                    vowelsCount++;
                }
                while (consonantsMatcher.find()) {
                    consonantsCount++;
                }

                if(vowelsCount == consonantsCount){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    @Override
    public void task6() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        String[] inputStrings = inputData.nextLine().split(" ");

        ArrayList<String> strings = new ArrayList<>();
        boolean flag = true;

        for (String string : inputStrings) {

            char[] charactersInWord = string.toCharArray();

            if(isSorted(charactersInWord)){
                String outWord = new String(charactersInWord);
                System.out.println(outWord);
            }else {
                flag = false;
            }
        }
        if(flag){
            System.out.println("NOT FOUND");
        }
    }

    @Override
    public void task7() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        String[] inputStrings = inputData.nextLine().split(" ");
        boolean flag = true;

        for (String word : inputStrings) {

            char[] charactersInWord = word.toCharArray();
            HashSet<Character> charactersSet = new HashSet<>();

            for (char characterInWord : charactersInWord) {

                charactersSet.add(characterInWord);
            }

            if(charactersInWord.length == charactersSet.size()){

                String outString = new String(charactersInWord);

                System.out.print(outString + " ");
            }else {
                flag = false;
            }
        }
        if(flag){
            System.out.println("NOT FOUND");
        }
    }

    @Override
    public void task8() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            try {
                size = Integer.parseInt(inputData.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Incorrect data format");
            }
        }

        String[] inputStrings = inputData.nextLine().split(" ");

        boolean flag = true;

        for (String word : inputStrings) {

            try {
                if (Integer.parseInt(word) != 0) {
                    char[] charactersInWord = word.toCharArray();
                    int i1 = 0;
                    int i2 = charactersInWord.length - 1;
                    while (i2 > i1) {
                        if (charactersInWord[i1] != charactersInWord[i2]) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                        }
                        ++i1;
                        --i2;
                    }
                    if (flag) {
                        System.out.println(word);
                    }
                }
            }catch (NumberFormatException e){
                continue;
            }

        }

    }

    @Override
    public void task9() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int out = 1;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                System.out.print(out + " ");
                out++;
            }
            System.out.println("\n");
        }
    }

    @Override
    public void task10() {
        Scanner inputData = new Scanner(System.in);

        String[] inputStrings = null;
        int[] conversionArray = new int[3];

        if(inputData.hasNext()){
            inputStrings = inputData.nextLine().split(" ");
        }

        try {
            for (int i = 0; i < 3; i++) {
                conversionArray[i] = Integer.valueOf(inputStrings[i]);
            }
        }catch (NullPointerException e){
            System.out.println("Wrong input type, try again nex time");
        }

        int a = conversionArray[0];
        int b = conversionArray[1];
        int c = conversionArray[2];


        double d = Math.pow(b, 2) - 4*a*c;

        double x1, x2;

        if(d > 0){
            x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2 * a);
            x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2 * a);
            System.out.printf("Two solutions: %f, %f\n", x1, x2);
        }
        if(d == 0){
            x1 = -b / (2*a);
            System.out.printf("One solution: %f\n", x1);
        }
        if(d < 0){
            System.out.printf("No solution\n");
        }

    }

    @Override
    public void task11() {
        Scanner inputData = new Scanner(System.in);

        int input = 0;

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};

        if (inputData.hasNextInt()) {
            input = Integer.parseInt(inputData.nextLine());
        }

        if(input > 0 && input <= 12){
            System.out.println(months[input - 1]);
        }else{
            System.out.println("INCORRECT INPUT DATA");
        }
    }

    @Override
    public void task12() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if(inputData.hasNextInt()){
            index = Integer.parseInt(inputData.nextLine());
        }

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<int[]> matrixRowList = new ArrayList<>();

        for(int i = 0; i < size; i++){
            String[] inputStrings = inputData.nextLine().split(" ");
            int[] row = new int[size];
            for(int j = 0; j < size; j++){
                row[j] = Integer.valueOf(inputStrings[j]);
            }
            matrixRowList.add(row);
        }

        matrixRowList.sort(Comparator.comparingInt(e -> e[index]));

        System.out.println(size);

        for (int[] elementOfList : matrixRowList) {
            for(int i = 0; i < size; i++){
                System.out.printf("%d ", elementOfList[i]);
            }
            System.out.println();
        }
    }

    @Override
    public void task13() {

    }

    @Override
    public void task14() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int[] inputArray = new int[size];

        String[] inputLine = inputData.nextLine().split(" ");
        for(int i = 0; i < size; i++){
            inputArray[i] = Integer.valueOf(inputLine[i]);
        }


        ArrayList<Integer> sequenceCountsList = new ArrayList<>();

        Integer count = 0;
        for (int i = 0; i < (size - 1); i++) {
            if(inputArray[i] < inputArray[i + 1]){
                count++;
            }else {
                sequenceCountsList.add(count);
                count = 1;
            }
        }

        System.out.println(sequenceCountsList.stream().max(Comparator.comparingInt(e -> e)).get());
    }
}
