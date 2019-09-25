package com.anatolik.mtable;

import java.util.HashMap;
import java.util.Map;

import static com.anatolik.mtable.Settings.*;

public class Test {

    private int complexity;
    private long testStart;
    private double score;
    private int numberOfQuestions;
    private Map<String, Integer> wrongAnswers;

    public Test(int complexity) {
        this.complexity = complexity;
    }

    private void init() {
        testStart = System.currentTimeMillis();
        score = 0;
        numberOfQuestions = 0;
        wrongAnswers = new HashMap<>();
    }

    public void perform() {
        init();
        while (toContinue()) {
            numberOfQuestions++;
            Task task = Task.getNewTask(complexity);
            long start = System.currentTimeMillis();
            int answer = ConsoleReader.askQuestion(task.getQuestion());
            long delta = System.currentTimeMillis() - start;
            if (task.checkResult(answer)) {
                score += BASE_DELTA / delta;
            } else {
                score -= delta / BASE_DELTA;
                wrongAnswers.put(task.getQuestion(), answer);
            }
        }
        ConsoleReader.printResult(new Result(numberOfQuestions, getResultScore(), wrongAnswers));
    }

    private boolean toContinue() {
        return System.currentTimeMillis() - testStart < TEST_TIME;
    }


    private long getResultScore() {
        score = (complexity / BASE_COMPLEXITY) * score;
        return Math.round(score * 10);
    }
}
