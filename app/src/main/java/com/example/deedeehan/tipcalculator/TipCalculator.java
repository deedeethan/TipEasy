package com.example.deedeehan.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class TipCalculator extends Activity {

    private EditText mBill;
    private EditText mTip;
    private Button mButton;
    private TextView mTotal;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        mBill = (EditText)findViewById(R.id.billEditText);
        mTip = (EditText)findViewById(R.id.tipEditText);
        mButton = (Button)findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double bill = Double.parseDouble(mBill.getText().toString());
                double tip = Double.parseDouble(mTip.getText().toString());
                total = bill * tip;
                // round to two decimal places
                DecimalFormat df = new DecimalFormat("#.##");
                total = Double.valueOf(df.format(total));
                // set to TextView and display on screen
                mTotal = (TextView)findViewById(R.id.totalAmount);
                mTotal.setText(String.valueOf(total));
            }
        });
    }
}
