package com.example.android.spanishvocabularyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    CheckBox question1_option1, question1_option2, question1_option3, question1_option4, question2_option1, question2_option2, question2_option3, question2_option4;
    Button btn_submitAnswers;
    EditText question3_answer, question4_answer;
    RadioButton question5_yes, question5_no, question6_yes, question6_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Question 1
        question1_option1 = (CheckBox) findViewById(R.id.question1_option1);
        question1_option2 = (CheckBox) findViewById(R.id.question1_option2);
        question1_option3 = (CheckBox) findViewById(R.id.question1_option3);
        question1_option4 = (CheckBox) findViewById(R.id.question1_option4);

        //Question 2
        question2_option1 = (CheckBox) findViewById(R.id.question2_option1);
        question2_option2 = (CheckBox) findViewById(R.id.question2_option2);
        question2_option3 = (CheckBox) findViewById(R.id.question2_option3);
        question2_option4 = (CheckBox) findViewById(R.id.question2_option4);

        question3_answer = (EditText) findViewById(R.id.question3_answer);

        question4_answer = (EditText) findViewById(R.id.question4_answer);

        btn_submitAnswers = (Button) findViewById(R.id.btn_submitAnswers);
        btn_submitAnswers.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String summaryAnswers = "Answer Summary";

                /**
                 * Question 1 : this text is added to the Answer Summary
                 */

                if (question1_option1.isChecked()) {
                    summaryAnswers += "\nSmart : Yes! ";
                }
                if (question1_option2.isChecked()) {
                    summaryAnswers += "\nClever: Yes! ";
                }
                if (question1_option3.isChecked()) {
                    summaryAnswers += "\nDifficult : Wrong Answer";
                }
                if (question1_option4.isChecked()) {
                    summaryAnswers += "\nDifficult : Wrong Answer";
                }

                /**
                 * Question 2 : this text is added to the Answer Summary
                 */

                if (question2_option1.isChecked()) {
                    summaryAnswers += "\nRich: Wrong Answer!";
                }
                if (question2_option2.isChecked()) {
                    summaryAnswers += "\nPretty: Yes! ";
                }
                if (question2_option3.isChecked()) {
                    summaryAnswers += "\nBig: Wrong Answer";
                }
                if (question2_option4.isChecked()) {
                    summaryAnswers += "\nBeautiful: Yes!";
                }

                /**
                 * Question 3 : this text is added to the Answer Summary
                 */


                Toast.makeText(getApplicationContext(), summaryAnswers, Toast.LENGTH_SHORT).show();
            }
        });
        }

     /**
      * When I check a checkbox
      * */

     public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
    }



    public int calculateCheckBoxAnswers() {

        /** Calculates the number of good answer
         */
        int score = 0;

        if (question1_option1.isChecked() && question1_option2.isChecked() &&
                !question1_option3.isChecked() && !question1_option4.isChecked()) {
            score++;
        }

        if (!question2_option1.isChecked() && question2_option2.isChecked() &&
                !question2_option3.isChecked() && question1_option4.isChecked()) {
            score++;
        }
        if (question3_answer.getText().equals("Money")) {
            score++;
        }

        if (question4_answer.getText().equals("Interview")) {
            score++;
        }
        if (!question5_yes.isChecked() && question5_no.isChecked()) {
            score++;
        }
        if (question6_yes.isChecked() && !question6_no.isChecked()) {
            score++;

        }
        return score;
    }
    /**
     * Create an answer summary.
     *
     * @param score of the good answers
     * @return answer summary
     *
     */

    private String createAnswerSummary(int score) {
        String answerMessage = "You have " + score + "good answers";
        answerMessage += "\nBuen trabajo! Keep Working!";
        return answerMessage;
    }

}