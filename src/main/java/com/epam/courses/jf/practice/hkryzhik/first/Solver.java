/*Warning: Some kind of crappy code. Eyebleeding is possible. You've been warn.
*/

package com.epam.courses.jf.practice.hkryzhik.first;


import com.epam.courses.jf.practice.common.first.ISolver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;

public class Solver implements ISolver {

    private static int index;

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

        System.out.printf("MIN (%d): \"%s\"%n", inputStringList.get(0).length(), inputStringList.get(0));
        System.out.printf("MAX (%d): \"%s\"%n" ,inputStringList.get(inputStringList.size() - 1).length(),
                inputStringList.get(inputStringList.size() - 1));
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
            System.out.printf("(%d): \"%s\"\n", string.length(), string);
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

        System.out.println("AVERAGE (" + stringLength + ")");

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

    //TODO: output needs to be fixed
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
            System.out.printf("Two solutions: %f, %f\n", BigDecimal.valueOf(x1)
                    .setScale(2, RoundingMode.DOWN)
                    .doubleValue(), BigDecimal.valueOf(x2)
                    .setScale(2, RoundingMode.DOWN)
                    .doubleValue());
        }
        if(d == 0){
            x1 = -b / (2*a);
            System.out.printf("One solution: %f\n", BigDecimal.valueOf(x1)
                    .setScale(2, RoundingMode.HALF_DOWN)
                    .doubleValue());
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
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        int shiftCount = 0;

        if (inputData.hasNextInt()) {
            shiftCount = Integer.parseInt(inputData.nextLine());
        }

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int[][] inputArray = new int[size][size];

        for (int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");
            for (int j = 0; j < size; j++) {

                inputArray[i][j] = Integer.valueOf(inputLine[j]);

            }
        }

        int[][] resultMatrix = new int[size][size];

        System.out.println(size);

        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                resultMatrix[((size * abs(shiftCount)) + i + shiftCount) % size][j] = inputArray[i][j];
            }
        }

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                System.out.printf("%d ", resultMatrix[i][j]);

            }
            System.out.println();
        }
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

    @Override
    public void task15() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int[][] inputArray = new int[size][size];


        for(int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            for (int j = 0; j < size; j++) {

                inputArray[i][j] = Integer.valueOf(inputLine[j]);
            }
        }

        int result = 0;

        for(int i = 0; i < size; i++){
            boolean flag = false;

            for(int j = 0; j < size; j++){
                if(!flag && inputArray[i][j] > 0){
                    flag = true;
                    continue;
                }
                if(flag && inputArray[i][j] < 0){
                    result += inputArray[i][j];
                    /*result += inputArray[i][j];
                    if (inputArray[i][j + 1] < 0 && j != size - 1) {
                        break;
                    }*/
                } else if (inputArray[i][j] > 0) {
                    break;
                }
                flag = false;
            }
        }

        System.out.println(result);
    }

    @Override
    public void task16() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int[][] inputArray = new int[size][size];

        for(int i = 0; i < size; i++) {
            String[] inputLine = inputData.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                inputArray[j][i] = Integer.valueOf(inputLine[j]);
            }
        }

        System.out.println(size);

        for(int i = size - 1; i != -1; i--){
            for(int j = 0; j < size; j++){
                System.out.printf("%d ", inputArray[i][j]);
            }
            System.out.println();
        }

    }

    //TODO: Shit to be done
    @Override
    public void task17() {

    }

    @Override
    public void task18() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int[][] inputArray = new int[size][size];


        for(int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            for (int j = 0; j < size; j++) {

                inputArray[i][j] = Integer.valueOf(inputLine[j]);
            }
        }

        int maxValue = 0;

        //finding max value
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(inputArray[i][j] > maxValue){
                    maxValue = inputArray[i][j];
                }
            }
        }

        ArrayList<Integer> rowsIndex = new ArrayList<>();
        ArrayList<Integer> columsIndex = new ArrayList<>();

        for(int i = 0; i < size; i++) {

            boolean flag = false;

            for (int j = 0; j < size; j++) {
                if(inputArray[i][j] == maxValue){
                    flag = true;
                    break;
                }else {
                    flag = false;
                }
            }
            if(flag){
                rowsIndex.add(i);
            }
        }

        for(int j = 0; j < size; j++) {
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                if(inputArray[i][j] == maxValue){
                    flag = true;
                    break;
                }else {
                    flag = false;
                }
            }
            if(flag){
                columsIndex.add(j);
            }
        }

        System.out.println(size - rowsIndex.size());
        System.out.println(size - columsIndex.size());

        for(int i = 0; i < size; i++){
            if(rowsIndex.contains(i)){
                continue;
            }else{
                for(int j = 0; j < size; j++){
                    if(columsIndex.contains(j)){
                        continue;
                    }else {
                        System.out.printf("%d ", inputArray[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }

    @Override
    public void task19() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        int[][] inputArray = new int[size][size];


        for(int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            for (int j = 0; j < size; j++) {

                inputArray[i][j] = Integer.valueOf(inputLine[j]);
            }
        }

        ArrayList<Integer> rowsIndex = new ArrayList<>();
        ArrayList<Integer> columsIndex = new ArrayList<>();

        for(int i = 0; i < size; i++) {

            boolean flag = false;

            for (int j = 0; j < size; j++) {
                if(inputArray[i][j] == 0){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                rowsIndex.add(i);
            }
        }

        for(int j = 0; j < size; j++) {
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                if(inputArray[i][j] == 0){
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                columsIndex.add(j);
            }
        }

        System.out.println(size - rowsIndex.size());
        System.out.println(size - columsIndex.size());

        for(int i = 0; i < size; i++){
            if(rowsIndex.contains(i)){
                continue;
            }else{
                for(int j = 0; j < size; j++){
                    if(columsIndex.contains(j)){
                        continue;
                    }else {
                        System.out.printf("%d ", inputArray[i][j]);
                    }
                }
                System.out.println();
            }
        }

    }

    //TODO: Shit to be done
    @Override
    public void task20(){

    }

    @Override
    public void task21() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<ArrayList<Integer>> inputArray = new ArrayList<>();


        for(int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            ArrayList<Integer> bufferList = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                if(Integer.valueOf(inputLine[j]) != 0) {
                    bufferList.add(Integer.valueOf(inputLine[j]));
                }
            }
            if(bufferList.size() < size){
                for(int k = 0; k <= size - bufferList.size(); k++){
                    bufferList.add(0);
                }
            }
            inputArray.add(bufferList);
        }

        System.out.println(size);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.printf("%d ", inputArray.get(i).get(j));
            }
            System.out.println();
        }


    }

    @Override
    public void task22() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        Double[][] inputArray = new Double[size][size];


        for(int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().replace(',', '.').split(" ");

            for (int j = 0; j < size; j++) {

                inputArray[i][j] = Double.valueOf(inputLine[j]);
            }
        }

        System.out.println(size);

        for(int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", Math.round(inputArray[i][j]));
            }
            System.out.println();
        }

    }

    @Override
    public void task23() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<ArrayList<Integer>> rowsList = new ArrayList<>();

        ArrayList<ArrayList<Integer>> collsList = new ArrayList<>();


        for (int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            ArrayList<Integer> rowBuffer = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                rowBuffer.add(Integer.valueOf(inputLine[j]));
            }
            rowsList.add(rowBuffer);
        }

        for (int i = 0; i < size; i++) {

            ArrayList<Integer> colBuffer = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                colBuffer.add(rowsList.get(j).get(i));
            }

            collsList.add(colBuffer);
        }

        int result = 0;

        for (int i = 0; i < size; i++) {

            int minItemInRow = rowsList.get(i).stream().min((e1, e2) -> e1 - e2).get();

            for(int j = 0; j < size; j++) {

                int maxItemInColl = collsList.get(j).stream().max((e1, e2) -> e1 - e2).get();

                if (minItemInRow == maxItemInColl) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }

    @Override
    public void task24() {
        Scanner inputData = new Scanner(System.in);

        if (inputData.hasNextInt()) {
            index = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<int[]> inputArray = new ArrayList<>();


        for(int i = 0; i < index; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            int[] bufferArray = new int[index];

            for (int j = 0; j < index; j++) {
                bufferArray[j] = Integer.valueOf(inputLine[j]);
            }
            inputArray.add(bufferArray);
        }

        inputArray.sort((e1, e2) -> {

            int e1Count = 0;
            int e2Count = 0;

            for(int i = 0; i < index; i++){
                e1Count += e1[i];
                e2Count += e2[i];
            }

            return e1Count - e2Count;
        });

        System.out.println(index);

        for(int i = 0; i < index; i++){
            for(int j = 0; j < index; j++){
                System.out.printf("%d ", inputArray.get(i)[j]);
            }
            System.out.println();
        }

    }

    //TODO: Shit to do here
    @Override
    public void task25() {

    }

    //TODO: So as here
    @Override
    public void task26() {

    }

    @Override
    public void task27() {
        Scanner inputData = new Scanner(System.in);

        int size = 0;

        if (inputData.hasNextInt()) {
            size = Integer.parseInt(inputData.nextLine());
        }

        ArrayList<int[]> rowsList = new ArrayList<>();

        ArrayList<int[]> collsList = new ArrayList<>();


        for (int i = 0; i < size; i++) {

            String[] inputLine = inputData.nextLine().split(" ");

            int[] rowBuffer = new int[size];

            for (int j = 0; j < size; j++) {
                rowBuffer[j] = Integer.valueOf(inputLine[j]);
            }
            rowsList.add(rowBuffer);
        }

        for (int i = 0; i < size; i++) {

            int[] colBuffer = new int[size];

            for (int j = 0; j < size; j++) {
                colBuffer[j] = rowsList.get(j)[i];
            }

            collsList.add(colBuffer);
        }

        collsList.sort((e1, e2) -> {

            int collE1ItemsCount = 0;

            int collE2ItemsCount = 0;

            for(int i = 0; i < e1.length; i++){
                collE1ItemsCount += abs(e1[i]);
                collE2ItemsCount += abs(e2[i]);
            }
            if(collE1ItemsCount == collE2ItemsCount){
                return 0;
            }

            return collE2ItemsCount - collE1ItemsCount;
        });

        System.out.println(size);

        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.printf("%d ", collsList.get(j)[i]);
            }
            System.out.println();
        }
    }
}
