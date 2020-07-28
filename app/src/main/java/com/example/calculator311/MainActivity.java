package com.example.calculator311;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView calculator;
    TextView calculatorResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init() {
        calculator = (TextView) findViewById(R.id.calculator);
        calculatorResult = (TextView) findViewById(R.id.calculatorResylt);
    }
    public void onNumberCkick(View view) {
        Button button = (Button) view;
        String newNumber = button.getText().toString();
        String calculatorText = calculator.getText().toString();
        String firstSimbol = "" + calculatorText.charAt(0);
        if ( firstSimbol.equals("0") && !calculatorText.contains(".")) {
            if(!newNumber.equals("0")) {
                calculator.setText(calculatorText.substring(1));
                calculator.append(newNumber);
            }
        } else {
            calculator.append(newNumber);
        }
    }
    public void onPointkick(View view) {
        Button button = (Button) view;
        String newNumber = button.getText().toString();
        String calculatorText = calculator.getText().toString();
        if ( !calculatorText.contains(".")) {
            calculator.append(newNumber);
        }
    }
    public void onResultCkick(View view) {
        String calculatorText = calculator.getText().toString();
        calculatorResult.setText(culc(calculatorText));
    }
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        String newOperator = button.getText().toString();
        String calculatorText = calculator.getText().toString();
        String firstSimbol = "" + calculatorText.charAt(0);
        Toast toast = Toast.makeText(getApplicationContext(), "Не правильное использование оператора", Toast.LENGTH_SHORT);
        switch (newOperator) {
            case "%":
                try{
                    double number = Double.parseDouble(calculatorText);
                    double result = (number/100);
                    calculatorResult.setText(String.valueOf(result));
                } catch (Exception e) {
                    toast.show();
                }
                break;
            case "+/-":
                if(!calculatorText.contains("+") && !calculatorText.contains("-") && !calculatorText.contains("/") && !calculatorText.contains("*")) {
                    String result;
                    if(firstSimbol.equals("-")) {
                        result = calculatorText.substring(1);
                    }
                    else {
                        result = "-" + calculatorText;
                    }
                    calculatorResult.setText(result);
                }
                else {
                    toast.show();
                }
                break;
            case "-":
                if(!calculatorText.contains("+") && !calculatorText.contains("-") && !calculatorText.contains("/") && !calculatorText.contains("*")) {
                    String result = "-" + calculatorText;
                    calculatorResult.setText(result);
                }
                else {
                    calculator.append(newOperator);
                }
            break;

            default:
                calculator.append(newOperator);
                break;
        }

    }
    public void onDeleteClick(View view) {
        Button button = (Button) view;
        String calculatorText = calculator.getText().toString();
        if(!calculatorText.equals("")) {
            calculator.setText(calculatorText.substring(0, calculatorText.length()-1));
        }
    }
    private String culc(String exp) {
        return "";
    }
}