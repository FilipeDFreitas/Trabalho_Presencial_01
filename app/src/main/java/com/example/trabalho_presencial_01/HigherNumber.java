package com.example.trabalho_presencial_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class HigherNumber extends AppCompatActivity {

    TextView number1, number2, number3;
    EditText answer;
    int number1Random,number2Random,number3Random, points, counter;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higher_number);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        answer = findViewById(R.id.answer);
        btnCalculate = findViewById(R.id.calculate);

        getRandom();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void getRandom() {
        Random r = new Random();
        number1Random = r.nextInt(10);
        number2Random = r.nextInt(10);
        number3Random = r.nextInt(10);

        number1.setText(Integer.toString(number1Random));
        number2.setText(Integer.toString(number2Random));
        number3.setText(Integer.toString(number3Random));
    }

    public void calculate() {
        int[] arr = {number1Random,number2Random,number3Random};
        Arrays.sort(arr);

        int result = arr[2]*100 + arr[1]*10 + arr[0];

        int userAnswer = Integer.valueOf(answer.getText().toString());

        if (userAnswer == result) {
                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(HigherNumber.this);
                dialog.setTitle("Success");
                dialog.setMessage("Congratulations! Your answer is right!");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        points = points + 20;
                        if (counter < 5) {
                            getRandom();
                        }
                        else {
                            Intent intent = new Intent(HigherNumber.this, Result.class);
                            intent.putExtra("points", points);
                            startActivity(intent);
                        }

                    }
                });
                dialog.create();
                dialog.show();
        } else {
                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(HigherNumber.this);
                dialog.setTitle("");
                dialog.setMessage("What a pity! your answer is wrong!");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (counter < 5) {
                            getRandom();
                        }
                        else {
                            Intent intent = new Intent(HigherNumber.this, Result.class);
                            intent.putExtra("points", points);
                            startActivity(intent);
                        }
                    }
                });
                dialog.create();
                dialog.show();
        }
        counter++;
    }
}