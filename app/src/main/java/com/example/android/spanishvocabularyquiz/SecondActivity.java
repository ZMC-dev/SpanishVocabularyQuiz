package com.example.android.spanishvocabularyquiz;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {


    CheckBox Q1_option1, Q1_option2, Q1_option3, Q2_option1, Q2_option2, Q2_option3;
    RadioButton Q5_optionYes, Q5_optionNo, Q6_optionYes, Q6_optionNo;
    Button btn_submitAnswers;
    String str_money, str_interview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        btn_submitAnswers = findViewById(R.id.btn_submitAnswers);

        btn_submitAnswers.setOnClickListener(new View.OnClickListener() {
            @Override

            /**
             * This method is called when the Submit Answer button is clicked, it can calculate a score and show a summary of good answers.
             *
             */
            public void onClick(View view) {

                // Question N°1 - CheckBox : the right answer is option 1 : "smart"
                CheckBox Q1_option1 = (CheckBox) findViewById(R.id.Q1_option1);
                CheckBox Q1_option2 = (CheckBox) findViewById(R.id.Q1_option2);
                CheckBox Q1_option3 = (CheckBox) findViewById(R.id.Q1_option3);


                // Question N°2 - CheckBox : the right answer is option 2 : "pretty"
                CheckBox Q2_option1 = (CheckBox) findViewById(R.id.Q2_option1);
                CheckBox Q2_option2 = (CheckBox) findViewById(R.id.Q2_option2);
                CheckBox Q2_option3 = (CheckBox) findViewById(R.id.Q2_option3);


                // Question N°3 - EditText : the right answer is "money"
                str_money ="money";
                EditText Q3_answer = (EditText) findViewById(R.id.Q3_answer);
                str_money = Q3_answer.getText().toString();


                // Question N°4 - EditText : the right answer is "interview"
                str_interview="interview";
                EditText Q4_answer = (EditText) findViewById(R.id.Q4_answer);
                str_interview = Q4_answer.getText().toString();


                // Question N°5 - RadioButtons : the right answer is NO
                RadioButton Q5_optionYes = findViewById(R.id.Q5_optionYes);
                RadioButton Q5_optionNo = findViewById(R.id.Q5_optionNo);

                // Question N°6 - RadioButtons : the right answer is YES
                RadioButton Q6_optionYes = findViewById(R.id.Q6_optionYes);
                RadioButton Q6_optionNo = findViewById(R.id.Q6_optionNo);


                int score = 0;
                String summary = ("Your Good Answers: ");

                if (Q1_option1.isChecked() && !Q1_option2.isChecked() &&
                        !Q1_option3.isChecked()) {
                    summary += ("\nQuestion 1- The right answers is Option 1: Smart");
                    score += +1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Question 1: Try it again!", Toast.LENGTH_LONG).show();
                }

                if (!Q2_option1.isChecked() && Q2_option2.isChecked() &&
                        !Q2_option3.isChecked()) {
                    summary += ("\nQuestion 2 - The right answers is Option 2: Pretty");
                    score += +1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Question 2: Try it again!", Toast.LENGTH_LONG).show();
                }

                if (str_money.equals("money") || str_money.equals("MONEY") || str_money.equals("Money")) {
                    summary += ("\nQuestion 3 - The right answer is MONEY");
                    score += 1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Question 3: Try it again!", Toast.LENGTH_LONG).show();
                }


                if (str_interview.equals("interview") || str_interview.equals("INTERVIEW") || str_interview.equals("Interview")) {
                    summary += ("\nQuestion 4 - The right answer is INTERVIEW");
                    score += 1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Question 4: Try it again!", Toast.LENGTH_LONG).show();
                }


                if (!Q5_optionYes.isChecked() && Q5_optionNo.isChecked()) {
                    summary += ("\nQuestion 5 = The right answer is NO");
                    score += +1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Question 5: Try it again!", Toast.LENGTH_LONG).show();
                }


                if (Q6_optionYes.isChecked() && !Q6_optionNo.isChecked()) {
                    summary += ("\nQuestion 6 - The right answer is YES");
                    score += +1;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Question 6: Try it again!", Toast.LENGTH_LONG).show();
                }

                displaySummary(summary);
                displayScore(score);
            }

        });

    }

    /**
     * This method displays a summary of right answers.
     * @param summary of good answers
     */

    private void displaySummary (String summary) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_tex_view);
        summaryTextView.setText(String.valueOf(summary));
    }

    /**
     * This method displays the score of right answers.
     * @param score of good answers
     */

    public void displayScore (int score) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText(String.valueOf(score));
    }

}









