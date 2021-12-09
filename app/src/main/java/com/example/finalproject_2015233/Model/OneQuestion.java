package com.example.finalproject_2015233.Model;
public class OneQuestion
{

    private String text;
    private int answer;

    public OneQuestion(String text, int answer)
    {
        this.text = text;
        this.answer = answer;
    }

    public String getText()
    {
        return text;
    }

    public int getAnswer()
    {
        return answer;
    }
}
