package com.example.android.spanishvocabularyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    CheckBox question1_option1, question1_option2, question1_option3, question1_option4, question2_option1, question2_option2, question2_option3, question2_option4;
    Button btn_submitAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        // instances for all checkboxes + button
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


        btn_submitAnswers = (Button) findViewById(R.id.btn_submitAnswers);
        btn_submitAnswers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String summaryAnswers = "Answer Summary";

              // Ce code pour le button marche puisque il affiche un récap des réponses mais il n'est pas encore lié au counter, je voudrais afficher le score

                // question n°1

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

                // question n°2

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

                Toast.makeText(getApplicationContext(), summaryAnswers, Toast.LENGTH_SHORT).show();
            }
        });
    }

/*
    // JE VOUDRAIS AFFICHER UN TOAST QUAND LA REPONSE POUR CHAQUE CASE SELECTED/DESELECTED MAIS PAS PRIORITAIRE

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";

        switch (view.getId()) {
            case R.id.question1_option1:
                str = checked ? "Nice" : "Oh! try again!";
                break;
            case R.id.question1_option2:
                str = checked ? "Good Job" : "Oh! try again";
                break;
            case R.id.question1_option3:
                str = checked ? "Are you sure?" : "Keep trying!";
                break;
            case R.id.question1_option4:
                str = checked ? "I don't think so" : "Keep working!";
                break;
        }
        Toast.makeText(SecondActivity.this,
                "Your Message", Toast.LENGTH_LONG).show();
    }*/


    // il faut que je fasse une méthode pour le counter aussi ? ce code devrais rajouter des points si les réponses sont bonnes

    int counter = 0;
    int score = 0;

    public void calculateCheckBoxAnswers(View view) {
        if (counter == 1) {

            // bonnes réponses pour la question 1 : 1 et 2
            question1_option1.setEnabled(false);
            question1_option2.setEnabled(false);
            question1_option3.setEnabled(false);
            question1_option4.setEnabled(false);

            // bonnes réponses pour la question 2 : 2 et 4
            question2_option1.setEnabled(false);
            question2_option2.setEnabled(false);
            question2_option3.setEnabled(false);
            question2_option4.setEnabled(false);
        }
        counter++;
        if (question1_option1.isChecked() && !question1_option2.isChecked() &&
                question2_option2.isChecked() && !question2_option4.isChecked())
            score++;

    }

}