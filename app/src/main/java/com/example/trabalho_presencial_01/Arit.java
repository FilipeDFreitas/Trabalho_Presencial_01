package com.example.trabalho_presencial_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import android.os.Bundle;

public class Arit extends AppCompatActivity {

    TextView aritmeticOutput;
    EditText answerInput;
    Button answerButton;
    int number1, number2;
    String[] operator = {"+", "-"};
    Random random = new Random();
    String symbol;
    int counter = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arit);

        aritmeticOutput = findViewById(R.id.aritmeticOutput);
        answerInput = findViewById(R.id.answerInput);
        answerButton = findViewById(R.id.answerButton);

        randomAritmetic();

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerInput.getText().toString().equals("")) {
                    AlertDialog.Builder dialog =
                            new AlertDialog.Builder(Arit.this);
                    dialog.setTitle("Empty Text");
                    dialog.setMessage("Please fill out this field");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            answerInput.setFocusableInTouchMode(true);
                            answerInput.requestFocus();
                        }
                    });
                    dialog.create();
                    dialog.show();
                } else {
                    getAnswer();
                }
            }
        });
    }

    static String getRandom(String[] arr) {
        Random myRandom = new Random();
        int rdm = myRandom.nextInt(arr.length);
        return arr[rdm];
    }

    public void randomAritmetic() {
        number1 = random.nextInt(10);
        number2 = random.nextInt(10);
        symbol= getRandom(operator);

        aritmeticOutput.setText(String.valueOf(number1) + " " + symbol + " " + String.valueOf(number2));
    }

    public void getAnswer(){
        int result = 0;
        if (symbol.equals("+")) {
            result = number1 + number2;
        } else if(symbol.equals("-")) {
            result = number1 - number2;
        }
        Integer input = Integer.valueOf(answerInput.getText().toString());
        if(input == result) {
            AlertDialog.Builder dialog =
                    new AlertDialog.Builder(Arit.this);
            dialog.setTitle("Success");
            dialog.setMessage("Congratulations! Your answer is right!");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    points = points + 20;
                    answerInput.setText("");
                    if (counter < 5) {
                        randomAritmetic();
                    }
                    else {
                        Intent intent = new Intent(Arit.this, Result.class);
                        intent.putExtra("points", points);
                        startActivity(intent);
                    }

                }
            });
            dialog.create();
            dialog.show();
        } else {
            AlertDialog.Builder dialog =
                    new AlertDialog.Builder(Arit.this);
            dialog.setTitle("Failure");
            dialog.setMessage("I'm sorry! Your answer is wrong!");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    answerInput.setText("");
                    if (counter < 5) {
                        randomAritmetic();
                    }
                    else {
                        Intent intent = new Intent(Arit.this, Result.class);
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