package com.anatolik.mtable;

import java.util.*;

import static com.anatolik.mtable.Settings.*;

public class Test {

    private int complexity;
    private long testStart;
    private double score;
    private int askedQuestions;
    private Map<String, Integer> taskMap = new HashMap<>();
    private Map<String, Integer> wrongAnswers = new HashMap<>();
    private List<String> questions;
    int pointer;

    public Test(int complexity) {
        this.complexity = complexity;
    }

    private void init() {
        initQuestions();
        testStart = System.currentTimeMillis();
    }

    private void initQuestions() {
        initTasks();
        Set<String> set = taskMap.keySet();
        questions = new ArrayList<>(set);
        Collections.shuffle(questions);
    }

    private void initTasks() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= complexity; j++) {
                String task = j + " x " + i + " = ";
                int answer = i * j;
                taskMap.put(task, answer);
            }
        }
    }

    public void perform() {
        init();
        while (toContinue()) {
            askedQuestions++;
            long start = System.currentTimeMillis();
            String question = questions.get(pointer);
            int answer = ConsoleReader.askQuestion(question);
            long delta = System.currentTimeMillis() - start;
            if (taskMap.get(question) == answer) {
                score += BASE_DELTA / delta;
            } else {
                score -= delta / BASE_DELTA;
                wrongAnswers.put(question, answer);
            }
            pointer++;
        }
        ConsoleReader.printResult(new Result(askedQuestions, getResultScore(), wrongAnswers));
    }

    private boolean toContinue() {
        return (System.currentTimeMillis() - testStart < TEST_TIME) && pointer < questions.size();
    }


    private long getResultScore() {
        score = (complexity / BASE_COMPLEXITY) * score;
        return Math.round(score * 10);
    }
}
