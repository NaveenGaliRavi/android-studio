package com.myappsrepo.convertapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText textInches;
    TextView textMeters;
    Button buttonConvert;
    double finalVal;
    String inchesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findView();
        buttonListner();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void findView() {
        textInches = findViewById(R.id.editInches);
        textMeters = findViewById(R.id.textinches);
        buttonConvert = findViewById(R.id.buttonConvert);
    }

    private void buttonListner() {

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inchesText = textInches.getText().toString();

                if (!inchesText.isEmpty()) {
                    double metersConvert = convertBlock();
                    showMeters(metersConvert);
                } else {
                    displyNull();
                }
            }
        });
    }

    private void displyNull() {
        textMeters.setText("Enter inches to get Meters");
    }

    private double convertBlock() {

        double inches = Double.parseDouble(inchesText);
        finalVal = 0.0254 * inches;

        return finalVal;
    }

    private void showMeters(double met) {

        textMeters.setText(met + "Meters");

    }


}