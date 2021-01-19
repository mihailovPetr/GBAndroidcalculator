package com.example.gbandroidcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private TextView textView;
    private Calculator calculator;
    StringBuilder expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        expression = new StringBuilder();
        initViews();
    }

    private void initViews() {
        editText = findViewById(R.id.editText);
        editText.setFocusable(false);
        textView = findViewById(R.id.textView);

        initButtonsClickListeners();
    }

    private void initButtonsClickListeners() {
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_minus = findViewById(R.id.button_minus);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_divide = findViewById(R.id.button_divide);
        Button button_equals = findViewById(R.id.button_equals);
        Button button_percent = findViewById(R.id.button_percent);
        Button button_parentheses = findViewById(R.id.button_parentheses);
        Button button_C = findViewById(R.id.button_C);
        Button button_plus_minus = findViewById(R.id.button_plus_minus);
        Button button_point = findViewById(R.id.button_point);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_equals.setOnClickListener(this);
        button_percent.setOnClickListener(this);
        button_parentheses.setOnClickListener(this);
        button_C.setOnClickListener(this);
        button_plus_minus.setOnClickListener(this);
        button_point.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                calculator.add('0');
                break;
            case R.id.button_1:
                calculator.add('1');
                break;
            case R.id.button_2:
                calculator.add('2');
                break;
            case R.id.button_3:
                calculator.add('3');
                break;
            case R.id.button_4:
                calculator.add('4');
                break;
            case R.id.button_5:
                calculator.add('5');
                break;
            case R.id.button_6:
                calculator.add('6');
                break;
            case R.id.button_7:
                calculator.add('7');
                break;
            case R.id.button_8:
                calculator.add('8');
                break;
            case R.id.button_9:
                calculator.add('9');
                break;
            case R.id.button_plus:
                calculator.add('+');
                break;
            case R.id.button_minus:
                calculator.add('-');
                break;
            case R.id.button_multiply:
                calculator.add('*');
                break;
            case R.id.button_divide:
                calculator.add('/');
                break;
            case R.id.button_equals:
                calculator.add('=');
                break;
            case R.id.button_C:
                calculator.add('C');
                break;
            case R.id.button_point:
                calculator.add('.');
                break;
        }
        editText.setText(calculator.getExpression());
        textView.setText(calculator.getResult());
    }

}