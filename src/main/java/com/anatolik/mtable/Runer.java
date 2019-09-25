package com.anatolik.mtable;

import java.io.IOException;

import static com.anatolik.mtable.Settings.COMPLEXITY;

public class Runer {

    public static void main(String[] args) throws IOException {
        int complexity = COMPLEXITY;
        if (complexity < 2) {
            complexity = ConsoleReader.askComplexity();
        }
        ConsoleReader.waitForStart(complexity);
        Test test = new Test(complexity);
        test.perform();
    }
}
