package com.anatolik.mtable;

import java.util.Map;
import java.util.Set;

public class Result {

    private int numberOfQuestions;
    private long score;
    private Map<String, Integer> wrongAnswers;


    public Result(int numberOfQuestions, long score, Map<String, Integer> wrongAnswers) {
        this.numberOfQuestions = numberOfQuestions;
        this.score = score;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public String toString() {
        Set<String> wrongAnswersKeySet = wrongAnswers.keySet();
        StringBuilder sb = new StringBuilder()
                .append("Number of questions: ").append(numberOfQuestions).append("\n")
                .append("Correct answers: ").append(numberOfQuestions - wrongAnswersKeySet.size()).append("\n")
                .append("Score: ").append(score).append("\n");
        if (wrongAnswersKeySet.size() > 0) {
            sb.append("~~~~~~~~~~~~FAILED~~~~~~~~~~~~\n");
            for (String question : wrongAnswersKeySet) {
                sb.append(question).append(wrongAnswers.get(question)).append("\n");
            }
        }
        return sb.toString();
    }

}
