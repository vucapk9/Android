package com.example.bi2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtHeight, edtWeight;
    private Button btnCalculateBMI;
    private TextView tvBMIResult, tvBMIDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        tvBMIResult = findViewById(R.id.tvBMIResult);
        tvBMIDiagnosis = findViewById(R.id.tvBMIDiagnosis);

        // Xử lý sự kiện khi nhấn nút
        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String name = edtName.getText().toString().trim();
        String heightStr = edtHeight.getText().toString().trim();
        String weightStr = edtWeight.getText().toString().trim();

        // Kiểm tra nếu các trường bị trống
        if (name.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Lấy giá trị chiều cao và cân nặng
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            // Tính BMI
            float bmi = weight / (height * height);
            tvBMIResult.setText(String.format("BMI: %.2f", bmi));

            // Chẩn đoán tình trạng cơ thể
            String diagnosis;
            if (bmi < 18) {
                diagnosis = "Người gầy";
            } else if (bmi >= 18 && bmi <= 24.9) {
                diagnosis = "Người bình thường";
            } else if (bmi >= 25 && bmi <= 29.9) {
                diagnosis = "Người béo phì độ I";
            } else if (bmi >= 30 && bmi <= 34.9) {
                diagnosis = "Người béo phì độ II";
            } else {
                diagnosis = "Người béo phì độ III";
            }

            tvBMIDiagnosis.setText("Chẩn đoán: " + diagnosis);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu không hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
