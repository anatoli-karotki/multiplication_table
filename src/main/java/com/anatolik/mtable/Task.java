package com.anatolik.mtable;

import java.util.Random;

public class Task {

    private int left;
    private int right;

    public Task(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public static Task getNewTask(int complexity) {
        Random random = new Random();
        int left = random.nextInt(complexity - 1) + 2;
        int right = random.nextInt(9 - 1) + 2;
        return new Task(left, right);
    }

    public String getQuestion() {
        return left + " x " + right + " = ";
    }

    public boolean checkResult(int answer) {
        return answer == left * right;
    }
}

