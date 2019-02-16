package com.example.android.spanishvocabularyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;



public class SecondActivity extends AppCompatActivity {


    CheckBox Q1_option1, Q1_option2, Q1_option3, Q1_option4, Q2_option1, Q2_option2, Q2_option3, Q2_option4;
    RadioButton Q5_optionYes, Q5_optionNo, Q6_optionYes, Q6_optionNo;
    Button btn_submitAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_submitAnswers = findViewById(R.id.btn_submitAnswers);

        btn_submitAnswers.setOnClickListener(new View.OnClickListener() {
            @Override

            /**
             * This method is called when the Submit Answer button is clicked.
             */
            public void onClick(View view) {

                // Question N°1 - CheckBox

                CheckBox Q1_option1 = (CheckBox) findViewById(R.id.Q1_option1);
                CheckBox Q1_option2 = (CheckBox) findViewById(R.id.Q1_option2);
                CheckBox Q1_option3 = (CheckBox) findViewById(R.id.Q1_option3);
                CheckBox Q1_option4 = (CheckBox) findViewById(R.id.Q1_option4);


                // Question N°2 - CheckBox
                CheckBox Q2_option1 = (CheckBox) findViewById(R.id.Q2_option1);
                CheckBox Q2_option2 = (CheckBox) findViewById(R.id.Q2_option2);
                CheckBox Q2_option3 = (CheckBox) findViewById(R.id.Q2_option3);
                CheckBox Q2_option4 = (CheckBox) findViewById(R.id.Q2_option4);


                // Question N°3 - EditText
                EditText Q3_answer = (EditText) findViewById(R.id.Q3_answer);

                // Question N°4 - EditText
                EditText Q4_answer = (EditText) findViewById(R.id.Q4_answer);


                // Question N°5 - RadioButtons
                RadioButton Q5_optionYes = findViewById(R.id.Q5_optionYes);
                RadioButton Q5_optionNo = findViewById(R.id.Q5_optionNo);

                // Question N°6 - RadioButtons
                RadioButton Q6_optionYes = findViewById(R.id.Q6_optionYes);
                RadioButton Q6_optionNo = findViewById(R.id.Q6_optionNo);


                int score = 0;
                String summary = ("Your Good Answers Summary : ");

                if (Q1_option1.isChecked() && Q1_option2.isChecked() &&
                        !Q1_option3.isChecked() && !Q1_option4.isChecked()) {
                    summary += ("\nThe right answers are Option 1 & Option 2");
                    score += +1;

                }

                if (!Q2_option1.isChecked() && Q2_option2.isChecked() &&
                        !Q2_option3.isChecked() && Q2_option4.isChecked()) {
                    summary += ("\nThe right answers are Option 2 & Option 4");
                    score += +1;
                }

                if (Q3_answer.equals("money")) {
                    summary += ("\nThe right answer is MONEY");
                    score += 1;
                }

                if (Q4_answer.equals("interview")) {
                    summary += ("\nThe right answer is INTERVIEW");
                    score += 1;
                }

                if (!Q5_optionYes.isChecked() && Q5_optionNo.isChecked()) {
                    summary += ("\nQuestion 5 = right answer: NO");
                    score += +1;

                }

                if (Q6_optionYes.isChecked() && !Q6_optionNo.isChecked()) {
                    summary += ("\nQuestion 5 = right answer: YES");
                    score += +1;
                }

                displaySummary(summary);
                displayScore(score);
            }

        });

    }

    private void displaySummary (String summary) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_tex_view);
        summaryTextView.setText(String.valueOf(summary));
    }


    public void displayScore (int score) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText(String.valueOf(score));
    }

}









