package com.example.finalproject_2015233.Model;

public class AnswerVerifier {
    public boolean isCorrect(OneQuestion question, double answer) {
        return question.getAnswer() == answer;
    }

    public int getAnswer(OneQuestion question)
    {
        return question.getAnswer();
    }
}
