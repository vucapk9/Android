package com.example.bi3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumberA, edtNumberB;
    private TextView tvResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        edtNumberA = findViewById(R.id.edtNumberA);
        edtNumberB = findViewById(R.id.edtNumberB);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // Xử lý các nút bấm
        btnAdd.setOnClickListener(view -> calculate("+"));
        btnSubtract.setOnClickListener(view -> calculate("-"));
        btnMultiply.setOnClickListener(view -> calculate("*"));
        btnDivide.setOnClickListener(view -> calculate("/"));
    }

    private void calculate(String operator) {
        String inputA = edtNumberA.getText().toString();
        String inputB = edtNumberB.getText().toString();

        if (inputA.isEmpty() || inputB.isEmpty()) {
            tvResult.setText("Vui lòng nhập đầy đủ số!");
            return;
        }

        double numA = Double.parseDouble(inputA);
        double numB = Double.parseDouble(inputB);
        double result = 0;

        switch (operator) {
            case "+":
                result = numA + numB;
                break;
            case "-":
                result = numA - numB;
                break;
            case "*":
                result = numA * numB;
                break;
            case "/":
                if (numB != 0) {
                    result = numA / numB;
                } else {
                    tvResult.setText("Không thể chia cho 0!");
                    return;
                }
                break;
        }

        tvResult.setText("Kết quả: " + result);
    }
}
