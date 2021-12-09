package com.example.finalproject_2015233.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject_2015233.Model.AnswerVerifier;
import com.example.finalproject_2015233.R;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnGoBack;
    TextView txtViewResults;

    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_results);


        initialize();
    }

    private void initialize()
    {
        btnGoBack = findViewById(R.id.btnGoBack);

        btnGoBack.setOnClickListener(this);

        txtViewResults=findViewById(R.id.txtViewResults);

        String sendData = getIntent().getStringExtra("sendData");
        String results = getIntent().getStringExtra("results");
        txtViewResults.setText(sendData + "\n" + results);
    }

    public void onClick(View view)
    {
        /*Intent intentMain = new Intent(getApplicationContext(), CalculatorActivity.class);
        startActivity(intentMain);

        AnswerVerifier answerVerifier = new AnswerVerifier();
        String results;*/



        finish();
    }
}

