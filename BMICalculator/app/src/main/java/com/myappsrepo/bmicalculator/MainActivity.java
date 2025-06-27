package com.myappsrepo.bmicalculator;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        String pop = "BMICalculator opened succesfully!!";
        Toast.makeText(this, pop,Toast.LENGTH_LONG).show();

        TextView resultText = findViewById(R.id.text_view_foot);

        RadioButton maleText = findViewById(R.id.radio_button_male);
        RadioButton femaleText = findViewById(R.id.radio_button_female);

        EditText ageEdit = findViewById(R.id.edit_text_age);
        EditText feetEdit = findViewById(R.id.edit_text_feet);
        EditText inchesEdit = findViewById(R.id.edit_text_inches);
        EditText weightEdit = findViewById(R.id.edit_text_weight);

        Button calculateButton = findViewById(R.id.button_calculate);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}