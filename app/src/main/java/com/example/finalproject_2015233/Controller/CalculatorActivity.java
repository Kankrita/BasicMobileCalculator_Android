package com.example.finalproject_2015233.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject_2015233.Model.AllQuestions;
import com.example.finalproject_2015233.Model.AnswerVerifier;
import com.example.finalproject_2015233.Model.OneQuestion;
import com.example.finalproject_2015233.R;

import java.util.concurrent.ThreadLocalRandom;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnPeriod, btnDash, btnQuit, btnGenerate, btnClear, btnShowAll, btnValidate;
    TextView txtViewQuestion;
    EditText editTxtAnswer;

    private int countRight = 0, countWrong = 0;
    private int rightPercent = 0, wrongPercent = 0;
    private int answerCount = 0;

    private String sendData = "";

    public int answer;
    public int correctAnswer;

    public int questionCount = 0;

    public final AllQuestions questionList = new AllQuestions();

    public AnswerVerifier verifier = new AnswerVerifier();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // generateQuestion();

        editTxtAnswer = findViewById(R.id.editTextResult);

        initialize();
    }

    private void initialize()
    {
        btnZero = findViewById(R.id.btn0);
        btnOne = findViewById(R.id.btn1);
        btnTwo = findViewById(R.id.btn2);
        btnThree = findViewById(R.id.btn3);
        btnFour = findViewById(R.id.btn4);
        btnFive = findViewById(R.id.btn5);
        btnSix = findViewById(R.id.btn6);
        btnSeven = findViewById(R.id.btn7);
        btnEight = findViewById(R.id.btn8);
        btnNine = findViewById(R.id.btn9);

        btnPeriod = findViewById(R.id.btnPeriod);
        btnDash = findViewById(R.id.btnDash);

        btnValidate = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);
        btnGenerate = findViewById(R.id.btnGenerate);
        btnShowAll = findViewById(R.id.btnShowAll);
        btnQuit = findViewById(R.id.btnQuit);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);

        btnPeriod.setOnClickListener(this);
        btnDash.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnValidate.setOnClickListener(this);
        btnGenerate.setOnClickListener(this);
        btnQuit.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnShowAll:
                goToResultsActivity();
                break;
            case R.id.btnEqual:
                saveAnswer();
                break;
            case R.id.btnClear:
                clearWidgets();
                break;
            case R.id.btnGenerate:
                generateQuestion();
                break;
            case R.id.btnQuit:
                finish();
                //System.exit(0);
            case R.id.btn0:
                editTxtAnswer.setText(editTxtAnswer.getText()+"0");
                break;
            case R.id.btn1:
                editTxtAnswer.setText(editTxtAnswer.getText()+"1");
                break;
            case R.id.btn2:
                editTxtAnswer.setText(editTxtAnswer.getText()+"2");
                break;
            case R.id.btn3:
                editTxtAnswer.setText(editTxtAnswer.getText()+"3");
                break;
            case R.id.btn4:
                editTxtAnswer.setText(editTxtAnswer.getText()+"4");
                break;
            case R.id.btn5:
                editTxtAnswer.setText(editTxtAnswer.getText()+"5");
                break;
            case R.id.btn6:
                editTxtAnswer.setText(editTxtAnswer.getText()+"6");
                break;
            case R.id.btn7:
                editTxtAnswer.setText(editTxtAnswer.getText()+"7");
                break;
            case R.id.btn8:
                editTxtAnswer.setText(editTxtAnswer.getText()+"8");
                break;
            case R.id.btn9:
                editTxtAnswer.setText(editTxtAnswer.getText()+"9");
                break;
            case R.id.btnPeriod:
                editTxtAnswer.setText(editTxtAnswer.getText()+".");
                break;
            case R.id.btnDash:
                editTxtAnswer.setText(editTxtAnswer.getText()+"-");
                break;
        }
    }

    private void saveAnswer()
   {
        try
        {
            answerCount++;
            answer = Integer.parseInt(editTxtAnswer.getText().toString());
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

            sendData += questionList.getListOfQuestions().get(answerCount).getText();

            if (answer == correctAnswer)
            {
                countRight++;
                sendData+= "\n " +  "Your answer is correct." + "\n" + "______________________" + "\n";
            }
            else
            {
                countWrong++;
                sendData+= "\n" + "Your answer is incorrect." + "\n" + "The correct answer is " + correctAnswer + "\n" + "______________________" + "\n";
            }

            rightPercent = (countRight * 100) / answerCount;
            wrongPercent = 100 - rightPercent;
        }
        catch(Exception e)
        {
            //No answer provided. Please verify your entry.
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
   }

    private void generateQuestion()
    {
        questionCount++;

        if (questionCount < 8)
        {
            OneQuestion question = questionList.getListOfQuestions().get(ThreadLocalRandom.current().nextInt(8));

            correctAnswer = verifier.getAnswer(question);
            {
                txtViewQuestion = findViewById(R.id.txtQuestion);
                txtViewQuestion.setText(question.getText());
            }
            clearWidgets();
        }
        else {
            Toast.makeText(this, "End of the quiz.", Toast.LENGTH_SHORT).show();
            btnGenerate.setEnabled(false);
        }
    }

    private void goToResultsActivity()
    {
        String results = "\n" + rightPercent + "% Correct answers" + "\n \n" + wrongPercent + "% Incorrect Answers" + "\n";

        Intent intentResults = new Intent(this, ResultsActivity.class);
        intentResults.putExtra("sendData", sendData);
        intentResults.putExtra("results", results);

        startActivity(intentResults);

        txtViewQuestion.setText("");
        questionCount = 0;
        btnGenerate.setEnabled(true);
        clearWidgets();
    }

    private void clearWidgets()
    {
        editTxtAnswer.setText("");
    }
}