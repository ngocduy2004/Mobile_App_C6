package com.example.nguyenngocduy_2123110108_app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.NumberFormat;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    ListView listView;
    TextView txtTotal;
    Button btnCheckout;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        // Cài padding khi có thanh hệ thống (status bar, navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ view
        listView = findViewById(R.id.listView);
        txtTotal = findViewById(R.id.txtTotal);
        btnCheckout = findViewById(R.id.btnCheckout);

        LinearLayout btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            startActivity(intent);
        });

        LinearLayout btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, settingActivity.class);
            startActivity(intent);
        });

        // Khởi tạo adapter với danh sách từ CartManager
        adapter = new CartAdapter(this, CartManager.cartItems, this::updateTotal);
        listView.setAdapter(adapter);

        // Hiển thị tổng tiền ban đầu
        updateTotal();

        // Sự kiện đặt hàng
        btnCheckout.setOnClickListener(v -> {
            if (CartManager.cartItems.isEmpty()) {
                Toast.makeText(this, "Giỏ hàng đang trống!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
                CartManager.cartItems.clear();
                adapter.notifyDataSetChanged();
                updateTotal();
            }
        });
    }

    private String formatCurrency(int amount) {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(amount) + "₫";
    }
    // Tính tổng tiền
    private void updateTotal() {
        int total = 0;
        for (CartItem item : CartManager.cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        txtTotal.setText("Tổng: " + formatCurrency(total));
    }
}
