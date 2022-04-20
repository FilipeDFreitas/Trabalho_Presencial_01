package com.example.trabalho_presencial_01;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    Integer points;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        points = (Integer) getIntent().getSerializableExtra("points");
        result = findViewById(R.id.resultOutput);
        if (points == 100) {
            result.setText("You've made " + points + " points. \n YOU ROCK IT!");
        } else {
            result.setText("You've made " + points + " points.");
        }
    }
    public void returnMenu(View view){
        Intent intent = new Intent(Result.this, MainActivity.class);
        startActivity(intent);
    }
}