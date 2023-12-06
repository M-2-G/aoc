package day1;

import java.io.*;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {
        solveDay1();
    }

    private static void solveDay1() {
        try {
            Scanner scanner = new Scanner(new File("resources/day1/part1/input"));
            int sum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sum += getCalibrationFromLine(line);
            }

            System.out.println("Result is: " + sum);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int getCalibrationFromLine(String line) {
        int leftDigit = 0;
        int rightDigit = 0;
        for (int i=0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i)) && leftDigit ==0) {
                leftDigit = Character.getNumericValue(line.charAt(i));
                rightDigit = leftDigit;
            } else if (Character.isDigit(line.charAt(i))) {
                rightDigit = Character.getNumericValue(line.charAt(i));
            }
        }
        System.out.println(String.format("Line: %s, left: %d, right: %d", line, leftDigit, rightDigit));
        return leftDigit*10 + rightDigit;
    }


}
