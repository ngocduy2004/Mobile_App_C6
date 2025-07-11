package com.example.nguyenngocduy_2123110108_app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoutPC, layoutPhone, layoutHeadphone, layoutGaming, layoutAll;


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

        // Gắn sự kiện click cho các nút chi tiết
        Button btnBook = findViewById(R.id.btnDetail_book);
        Button btnIphone = findViewById(R.id.btnDetail_iphone);
        Button btnHeadphone = findViewById(R.id.btnDetail_headphone);
        Button btnPs5 = findViewById(R.id.btnDetail_ps5);
        Button btnS24 = findViewById(R.id.btnDetail_s24);
        Button btnP47m = findViewById(R.id.btnDetail_p47m);
        LinearLayout btnSettings = findViewById(R.id.btnSettings);

        layoutPC = findViewById(R.id.layout_pc);
        layoutPhone = findViewById(R.id.layout_phone);
        layoutHeadphone = findViewById(R.id.layout_headphone);
        layoutGaming = findViewById(R.id.layout_gaming);
        layoutAll = findViewById(R.id.layout_all);

        layoutPC.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn chọn danh mục: PC", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, ProductListActivity.class).putExtra("category", "PC"));
        });

        layoutPhone.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn chọn danh mục: Phone", Toast.LENGTH_SHORT).show();
        });

        layoutHeadphone.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn chọn danh mục: Tai Nghe", Toast.LENGTH_SHORT).show();
        });

        layoutGaming.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn chọn danh mục: Máy Chơi Game", Toast.LENGTH_SHORT).show();
        });

        layoutAll.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn chọn: View All", Toast.LENGTH_SHORT).show();
        });

        layoutPC.setOnClickListener(v -> openProductList("pc"));
        layoutPhone.setOnClickListener(v -> openProductList("phone"));
        layoutHeadphone.setOnClickListener(v -> openProductList("headphone"));
        layoutGaming.setOnClickListener(v -> openProductList("gaming"));
        layoutAll.setOnClickListener(v -> openProductList("all"));


        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, settingActivity.class);
            startActivity(intent);
        });
        LinearLayout btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });

        Button btnProduct = findViewById(R.id.btnDetail_product);
        btnProduct.setOnClickListener(v -> {
            try {
                // Chuyển giá thành int (loại bỏ . và chữ)
                int priceValue = Integer.parseInt("20.000.000 VNĐ".replaceAll("[^\\d]", ""));

                // Tạo CartItem
                CartItem item = new CartItem("MacBook Pro 13 M2 Chip", priceValue, 1, R.drawable.macbook);

                // Thêm vào giỏ
                CartManager.cartItems.add(item);

                Toast.makeText(MainActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Lỗi định dạng giá", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnProduct1 = findViewById(R.id.btnDetail_product1);
        btnProduct1.setOnClickListener(v -> {
            try {
                // Chuyển giá thành int (loại bỏ . và chữ)
                int priceValue = Integer.parseInt("27.999.000 VNĐ".replaceAll("[^\\d]", ""));

                // Tạo CartItem
                CartItem item = new CartItem("Iphone 13 Pro Max 256GB", priceValue, 1, R.drawable.iphone13pro);

                // Thêm vào giỏ
                CartManager.cartItems.add(item);

                Toast.makeText(MainActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Lỗi định dạng giá", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnProduct2 = findViewById(R.id.btnDetail_product2);
        btnProduct2.setOnClickListener(v -> {
            try {
                // Chuyển giá thành int (loại bỏ . và chữ)
                int priceValue = Integer.parseInt("5.999.000 VNĐ".replaceAll("[^\\d]", ""));

                // Tạo CartItem
                CartItem item = new CartItem("Tai Nghe Bluetooth Tai Mèo Gradient", priceValue, 1, R.drawable.tainghe);

                // Thêm vào giỏ
                CartManager.cartItems.add(item);

                Toast.makeText(MainActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Lỗi định dạng giá", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnProduct3 = findViewById(R.id.btnDetail_product3);
        btnProduct3.setOnClickListener(v -> {
            try {
                // Chuyển giá thành int (loại bỏ . và chữ)
                int priceValue = Integer.parseInt("12.999.000 VNĐ".replaceAll("[^\\d]", ""));

                // Tạo CartItem
                CartItem item = new CartItem("Máy Chơi Game PlayStation 5 Pro", priceValue, 1, R.drawable.ps5);

                // Thêm vào giỏ
                CartManager.cartItems.add(item);

                Toast.makeText(MainActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Lỗi định dạng giá", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnProduct4 = findViewById(R.id.btnDetail_product4);
        btnProduct4.setOnClickListener(v -> {
            try {
                // Chuyển giá thành int (loại bỏ . và chữ)
                int priceValue = Integer.parseInt("27.999.000 VNĐ".replaceAll("[^\\d]", ""));

                // Tạo CartItem
                CartItem item = new CartItem("Galaxy S24 Ultra", priceValue, 1, R.drawable.samsungs24);

                // Thêm vào giỏ
                CartManager.cartItems.add(item);

                Toast.makeText(MainActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Lỗi định dạng giá", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnProduct5 = findViewById(R.id.btnDetail_product5);
        btnProduct5.setOnClickListener(v -> {
            try {
                // Chuyển giá thành int (loại bỏ . và chữ)
                int priceValue = Integer.parseInt("7.999.000 VNĐ".replaceAll("[^\\d]", ""));

                // Tạo CartItem
                CartItem item = new CartItem("Tai Nghe P47M", priceValue, 1, R.drawable.tainghep47m);

                // Thêm vào giỏ
                CartManager.cartItems.add(item);

                Toast.makeText(MainActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Lỗi định dạng giá", Toast.LENGTH_SHORT).show();
            }
        });




        btnBook.setOnClickListener(v -> openDetail("MacBook Pro 13 M2 chip", "20.000.000 VNĐ", R.drawable.macbook));
        btnIphone.setOnClickListener(v -> openDetail("Iphone 13 Pro Max 256GB", "27.999.000 VNĐ", R.drawable.iphone13pro));
        btnHeadphone.setOnClickListener(v -> openDetail("Tai Nghe Bluetooth Tai Mèo Gradient", "5.999.000 VNĐ", R.drawable.tainghe));
        btnPs5.setOnClickListener(v -> openDetail("Máy Chơi Game PlayStation 5 Pro", "12.999.000 VNĐ", R.drawable.ps5));
        btnS24.setOnClickListener(v -> openDetail("Galaxy S24 Ultra", "27.999.000 VNĐ", R.drawable.samsungs24));
        btnP47m.setOnClickListener(v -> openDetail("Tai Nghe P47M", "7.999.000 VNĐ", R.drawable.tainghep47m));

    }

    private void openDetail(String name, String price, int imageResId) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("image", imageResId);
        startActivity(intent);
    }
    // Hàm mở màn hình
    private void openProductList(String category) {
        Intent intent = new Intent(this, ProductListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
    
}
