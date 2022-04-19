package com.example.trabalho_presencial_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    Integer points;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        points = (Integer) getIntent().getSerializableExtra("points");
        result = findViewById(R.id.resultOutput);
        result.setText("You've made " + points + " points.");
    }
}
