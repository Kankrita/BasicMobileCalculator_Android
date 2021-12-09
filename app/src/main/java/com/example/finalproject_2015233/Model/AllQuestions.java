package com.example.finalproject_2015233.Model;

import java.util.ArrayList;
import java.util.List;

public class AllQuestions
{
    public List<OneQuestion> getListOfQuestions()
    {
        return new ArrayList<OneQuestion>()
        {
            {
                add(new OneQuestion("92 - 90 = ?", 2));
                add(new OneQuestion("0 * 1 = ?", 0));
                add(new OneQuestion("78 - 8 = ?", 88));
                add(new OneQuestion("34 - 49 = ?", -15));
                add(new OneQuestion("22 + 33 = ?", 55));
                add(new OneQuestion("100 / 4 = ?", 25));
                add(new OneQuestion("1 - 7 = ?", -6));
                add(new OneQuestion("70 * 22 = ?", 1540));
                add(new OneQuestion("12 / 3 = ?", 4));
                add(new OneQuestion("19 - 5 = ?", 14));
                add(new OneQuestion("14 + 17 = ?", 31));
                add(new OneQuestion("127 * 3 = ?", 381));

            }
        };
    }
}

