package com.example.nguyenngocduy_2123110108_app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class settingActivity extends AppCompatActivity {

    private Switch switchDarkMode;
    private Button btnChangeLanguage, btnLogout , btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting); // Gọi layout activity_setting.xml

        // Tự động điều chỉnh padding cho hệ điều hành mới
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ view từ layout
        switchDarkMode = findViewById(R.id.switchDarkMode);
        btnChangeLanguage = findViewById(R.id.btnChangeLanguage);
        btnLogout = findViewById(R.id.btnLogout);
        LinearLayout btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(settingActivity.this, MainActivity.class);
            startActivity(intent);
        });

        LinearLayout btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(settingActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Xử lý sự kiện bật/tắt chế độ tối
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this, isChecked ? "Đã bật chế độ tối" : "Đã tắt chế độ tối", Toast.LENGTH_SHORT).show();
        });

        // Xử lý đổi ngôn ngữ
        btnChangeLanguage.setOnClickListener(v -> {
            Toast.makeText(this, "Chức năng đổi ngôn ngữ chưa hỗ trợ", Toast.LENGTH_SHORT).show();
        });

        // Xử lý đăng xuất
        btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(settingActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Xóa các activity trước đó
            startActivity(intent);
        });

    }
}
