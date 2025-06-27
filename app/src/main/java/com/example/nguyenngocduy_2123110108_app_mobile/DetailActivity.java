package com.example.nguyenngocduy_2123110108_app_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.button.MaterialButton;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    ImageView imgProduct;
    TextView tvProductName, tvProductPrice, tvProductDesc;
    String name, price, desc;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Cài padding tự động khi có system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ view
        imgProduct = findViewById(R.id.imgProduct);
        tvProductName = findViewById(R.id.tvProductName);
        tvProductPrice = findViewById(R.id.tvProductPrice);
        tvProductDesc = findViewById(R.id.tvProductDesc);
        ImageView btnBack = findViewById(R.id.btnBack);

        MaterialButton btnBuyNow = findViewById(R.id.btnBuyNow);
        btnBuyNow.setOnClickListener(v -> {
            if (name != null && price != null) {
                try {
                    int priceValue = Integer.parseInt(price.replaceAll("[^0-9]", ""));
                    CartItem item = new CartItem(name, priceValue, 1, image);
                    CartManager.cartItems.add(item);

                    Toast.makeText(DetailActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(DetailActivity.this, "Lỗi giá sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(v -> finish());


        // Nhận dữ liệu từ Intent
        name = getIntent().getStringExtra("name");
        price = getIntent().getStringExtra("price");
        desc = getIntent().getStringExtra("desc");
        image = getIntent().getIntExtra("image", 0);
        if (image != 0) {
            imgProduct.setImageResource(image);
        }

        // Gán dữ liệu lên giao diện
        tvProductName.setText(name);
        tvProductPrice.setText(price);
        tvProductDesc.setText(desc);
        imgProduct.setImageResource(image);
    }
}
