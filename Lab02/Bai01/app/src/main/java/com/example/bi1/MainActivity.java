package com.example.bi1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtFahrenheit, edtCelsius;
    private Button btnToCelsius, btnToFahrenheit, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        edtFahrenheit = findViewById(R.id.edtFahrenheit);
        edtCelsius = findViewById(R.id.edtCelsius);
        btnToCelsius = findViewById(R.id.btnToCelsius);
        btnToFahrenheit = findViewById(R.id.btnToFahrenheit);
        btnClear = findViewById(R.id.btnClear);

        // Chuyển đổi từ F → C
        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheit = edtFahrenheit.getText().toString();
                if (!fahrenheit.isEmpty()) {
                    try {
                        double f = Double.parseDouble(fahrenheit);
                        double c = (f - 32) * 5 / 9;
                        edtCelsius.setText(String.format("%.2f", c));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input for Fahrenheit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a value in Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Chuyển đổi từ C → F
        btnToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsius = edtCelsius.getText().toString();
                if (!celsius.isEmpty()) {
                    try {
                        double c = Double.parseDouble(celsius);
                        double f = c * 9 / 5 + 32;
                        edtFahrenheit.setText(String.format("%.2f", f));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input for Celsius", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a value in Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xóa dữ liệu
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtFahrenheit.setText("");
                edtCelsius.setText("");
            }
        });
    }
}
