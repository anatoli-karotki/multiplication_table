package com.anatolik.mtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleReader {

    public static int askComplexity() {
        System.out.println("Choose complexity of the task (a number from 2 infinity)");
        int complexity = getIntAnswer();
        if (complexity < 2) {
            return askComplexity();
        } else {
            return complexity;
        }
    }

    public static void waitForStart(int complexity) {
        System.out.println("Complexity " + complexity + " chosen. Let's GO!");
        System.out.println("Press ENTER to start...");
        getAnswer();
    }

    public static int askQuestion(String question) {
        System.out.println(question);
        return getIntAnswer();
    }

    public static void printResult(Result result) {
        System.out.println("--------------------------");
        System.out.println(result.toString());
    }

    private static String getAnswer() {
        String inputString = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            inputString = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }

    private static int getIntAnswer() {
        String inputString = getAnswer();
        return parse(inputString);
    }

    private static int parse(String s) {
        Pattern p = Pattern.compile(".*?(\\d+).*");
        Matcher matcher = p.matcher(s);
        if (matcher.matches()) {
            s = matcher.group(1);
            return Integer.parseInt(s);
        } else {
            System.out.println("Not a number! Be careful");
            return 0;
        }
    }
}
