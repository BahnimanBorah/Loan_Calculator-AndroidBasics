package com.bahniman.testing.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox home,car;
    EditText amount,rate,duration;
    RadioButton male,female;
    Button calculate;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.amount);
        rate  = findViewById(R.id.rateofinterest);
        duration = findViewById(R.id.duration);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        car = findViewById(R.id.car);
        home = findViewById(R.id.home);
        amount.setInputType(InputType.TYPE_CLASS_NUMBER);
        rate.setInputType(InputType.TYPE_CLASS_NUMBER);
        duration.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public void calculateLoan(View view) {
        float pamt = Float.parseFloat(amount.getText().toString());
        float roi = Float.parseFloat(rate.getText().toString());
        float time = Float.parseFloat(duration.getText().toString());

        float r = roi/100;
        float totalAmount = pamt+((1+(r*time))*1000);
        float interest = (totalAmount-pamt);
        float monthlyemi = totalAmount/(12*time);

        String loantype="";
        if(home.isChecked())
            loantype="Home Loan";
        else if(car.isChecked())
            loantype="Car Loan";
        else
            loantype="Not selected";

        String gender = "";
        if(male.isChecked())
            gender="Male";
        else  if (female.isChecked())
            gender="Female";

        result.setText("Loan Type: " + loantype + "\nGender: " + gender + "\nTotal Amount: Rs." + totalAmount + "\nTotal Interest: Rs." + interest + "\nMonthly EMI: Rs." + monthlyemi);
    }
}
