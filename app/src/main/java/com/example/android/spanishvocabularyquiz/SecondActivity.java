package com.example.android.spanishvocabularyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    /**
     * This method is called when the Submit Answer button is clicked.
     */
    public void submitAnswers(View view) {

        // Question N°1 - CheckBox

        CheckBox Q1_option1 = findViewById(R.id.Q1_option1);
        boolean Q1_option1_Check = Q1_option1.isChecked();

        CheckBox Q1_option2 = findViewById(R.id.Q1_option2);
        boolean Q1_option2_Check = Q1_option2.isChecked();

        CheckBox Q1_option3 = findViewById(R.id.Q1_option3);
        boolean Q1_option3_Check = Q1_option3.isChecked();

        CheckBox Q1_option4 = findViewById(R.id.Q1_option4);
        boolean Q1_option4_Check = Q1_option4.isChecked();


        // Question N°2 - CheckBox

        CheckBox Q2_option1 = findViewById(R.id.Q2_option1);
        boolean Q2_option1_Check = Q2_option1.isChecked();

        CheckBox Q2_option2 = findViewById(R.id.Q2_option2);
        boolean Q2_option2_Check = Q2_option2.isChecked();

        CheckBox Q2_option3 = findViewById(R.id.Q2_option3);
        boolean Q2_option3_Check = Q2_option3.isChecked();

        CheckBox Q2_option4 = findViewById(R.id.Q2_option4);
        boolean Q2_option4_Check = Q2_option4.isChecked();

        // Question N°3 - EditText
        EditText Q3_answer = findViewById(R.id.Q3_answer);
        String Q3_answer_money = Q3_answer.getText().toString();


        // Question N°4 - EditText
        EditText Q4_answer = findViewById(R.id.Q4_answer);
        String Q4_answer_interview = Q4_answer.getText().toString();


        // Question 5 - RadioButton

        RadioButton Q5_optionYes = findViewById(R.id.Q5_optionYes);
        boolean Q5_optionYes_Check = Q5_optionYes.isChecked();

        RadioButton Q5_optionNo = findViewById(R.id.Q5_optionNo);
        boolean Q5_optionNo_Check = Q5_optionNo.isChecked();

        // Question 6 - RadioButton

        RadioButton Q6_optionYes = findViewById(R.id.Q6_optionYes);
        boolean Q6_optionYes_Check = Q6_optionYes.isChecked();

        RadioButton Q6_optionNo = findViewById(R.id.Q6_optionNo);
        boolean Q6_optionNo_Check = Q6_optionNo.isChecked();


        // Calculate the score
        int score = calculateScore(Q1_option1_Check, Q1_option2_Check, Q1_option3_Check, Q1_option4_Check, Q2_option1_Check, Q2_option2_Check, Q2_option3_Check, Q2_option4_Check, Q3_answer_money, Q4_answer_interview, Q5_optionYes_Check, Q5_optionNo_Check, Q6_optionYes_Check, Q6_optionNo_Check);
        displayScore(score);


        // Display the order summary on the screen
        String answerSummary = createAnswerSummary(score);
        displayMessage(answerSummary);

    }

    /**
     * Calculates the number of good answers of question
     *
     * @param Q1_option1_Check    if option 1 of question 1 was checked
     * @param Q1_option2_Check    if option 2 of question 1 was checked
     * @param Q1_option3_Check    if option 3 of question 1 was checked
     * @param Q1_option4_Check    if option 4 of question 1 was checked
     * @param Q2_option1_Check    if option 1 of question 2 was checked
     * @param Q2_option2_Check    if option 2 of question 2 was checked
     * @param Q2_option3_Check    if option 3 of question 2 was checked
     * @param Q2_option4_Check    if option 4 of question 2 was checked
     * @param Q3_answer_money     is the answer of question 3
     * @param Q4_answer_interview is the answer of question 4
     * @param Q5_optionYes_Check  is the wrong choice for question 5
     * @param Q5_optionNo_Check   is the right choice for question 5
     * @param Q6_optionYes_Check  is the right choice for question 6
     * @param Q6_optionNo_Check   is he wrong choice for question 7
     * @return a score
     */

    public int calculateScore(boolean Q1_option1_Check, boolean Q1_option2_Check,
                              boolean Q1_option3_Check, boolean Q1_option4_Check, boolean Q2_option1_Check, boolean Q2_option2_Check, boolean Q2_option3_Check, boolean Q2_option4_Check, String Q3_answer_money, String Q4_answer_interview, boolean Q5_optionYes_Check, boolean Q5_optionNo_Check, boolean Q6_optionYes_Check, boolean Q6_optionNo_Check) {

        int score = 0;

        if (Q1_option1_Check && Q1_option2_Check &&
                !Q1_option3_Check && !Q1_option4_Check) {
            score = score + 1;
        }

        if (!Q2_option1_Check && Q2_option2_Check &&
                !Q2_option3_Check && Q2_option4_Check) {
            score = score + 1;
        }

        if (Q3_answer_money.equals("money")) {
            score = score + 1;
        }

        if (Q4_answer_interview.equals("interview")) {
            score = score + 1;
        }

        if (!Q5_optionYes_Check && Q5_optionNo_Check) {
            score = score + 1;
        }

        if (Q6_optionYes_Check && !Q6_optionNo_Check) {
            score = score + 1;
        }
        return score;

    }

    /**
     * Create a Summary about answers
     *
     * @param score about good answers
     * @return Answer summary
     */

    private String createAnswerSummary(int score) {
        String answerSummary = "You have " + score + "good answers";
        answerSummary += "\nBuen trabajo! Keep Working!";
        return answerSummary;
    }

    /**
     * This method displays the score of right answers value on the screen.
     */

    private void displayScore(int score) {
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText(score);
    }


    /**
     * This method displays the summary of answers value on the screen.
     */

    private void displayMessage(String answerSummary) {
        TextView answerSummaryTextView = findViewById(R.id.answer_summary_textView);
        answerSummaryTextView.setText(answerSummary);


    }


}

