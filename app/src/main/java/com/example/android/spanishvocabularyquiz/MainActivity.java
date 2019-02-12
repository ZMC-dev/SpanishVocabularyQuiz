package com.example.android.spanishvocabularyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button start_quiz_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_quiz_button = findViewById(R.id.start_quiz_button);
        start_quiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
    }

    public void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
