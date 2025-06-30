package com.myappsrepo.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button calculateButton;
    TextView resultText;
    RadioButton maleText;
    RadioButton femaleText;
    EditText ageEdit;
    EditText feetEdit;
    EditText inchesEdit;
    EditText weightEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        String pop = "BMICalculator opened succesfully!!";
        Toast.makeText(this, pop,Toast.LENGTH_LONG).show();

        findviews();
        buttonListner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void findviews() {
        resultText = findViewById(R.id.text_view_foot);
        maleText = findViewById(R.id.radio_button_male);
        femaleText = findViewById(R.id.radio_button_female);
        ageEdit = findViewById(R.id.edit_text_age);
        feetEdit = findViewById(R.id.edit_text_feet);
        inchesEdit = findViewById(R.id.edit_text_inches);
        weightEdit = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void buttonListner() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Button clicked succesfully!!!",Toast.LENGTH_LONG).show();
                calculateBmi();
            }
        });
    }

    private void calculateBmi() {
        String ageText= ageEdit.getText().toString();
        String feetText= feetEdit.getText().toString();
        String inchesText= inchesEdit.getText().toString();
        String weighttext= weightEdit.getText().toString();

        Integer age = Integer.parseInt(ageText);
        Integer feet = Integer.parseInt(feetText);
        Integer inches = Integer.parseInt(inchesText);
        Integer weight = Integer.parseInt(weighttext);

        Integer feetInInches = feet*12;
        double heightInMeters = feetInInches * 0.0254;

        double bmi = weight / (heightInMeters*heightInMeters);

        String bmistr = String.valueOf(bmi);
        resultText.setText(bmistr);


    }


}