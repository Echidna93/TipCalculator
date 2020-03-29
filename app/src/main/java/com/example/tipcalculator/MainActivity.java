package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calcButton;
    private TextView resultView;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enteredDollarAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enteredAmount = (EditText) findViewById(R.id.userAmountID);
        seekBar = (SeekBar) findViewById(R.id.seekBarID);
        calcButton = (Button) findViewById(R.id.calculateButtonID);
        resultView = (TextView) findViewById(R.id.resultID);
        textViewSeekBar = (TextView) findViewById(R.id.textViewSeekBarID);
        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();
            }
        });
    }
        public void calculate(){
            float result = 0.00f;
            if(enteredAmount.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Please Enter a Valid Bill Amount.", Toast.LENGTH_LONG).show();
            }else{
                enteredDollarAmount = Float.parseFloat(enteredAmount.getText().toString());
                result = (enteredDollarAmount * seekBarPercentage) / 100;
                resultView.setText("Your tip will be " + String.valueOf(result));
            }
        }
    }

