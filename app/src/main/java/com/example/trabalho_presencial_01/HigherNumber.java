package com.example.trabalho_presencial_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class HigherNumber extends AppCompatActivity {

    TextView number1, number2, number3;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higher_number);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        answer = findViewById(R.id.answer);


    }


    public void calculate(View view) {
        Random r = new Random();
        int number1Random = r.nextInt(10);
        int number2Random = r.nextInt(10);
        int number3Random = r.nextInt(10);

        number1.setText(number1Random);
        number2.setText(number2Random);
        number3.setText(number3Random);
    }
}