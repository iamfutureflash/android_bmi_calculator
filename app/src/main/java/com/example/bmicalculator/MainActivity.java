package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculateBmi;
        TextView txtResult;
        LinearLayout main = findViewById(R.id.main);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculateBmi = findViewById(R.id.btn_Calculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {


                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;

                double totalCm = totalIn * 2.53;

                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);
                String formattedBMI = String.format("%.2f", bmi);
                if (bmi > 25) {
                    txtResult.setText("you're overweight " + formattedBMI);
                    main.setBackgroundColor(getResources().getColor(R.color.colorOW,getTheme()));
                } else if (bmi < 18) {
                    txtResult.setText("you're UnderWeight " + formattedBMI);
                    main.setBackgroundColor(getResources().getColor(R.color.colorUW,getTheme()));
                } else {
                    txtResult.setText("you're healthy " + formattedBMI);
                    main.setBackgroundColor(getResources().getColor(R.color.colorH,getTheme()));
                }

                Log.i("ashkad", "hello");
            }
        });

    }
}