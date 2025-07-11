package com.example.nguyenngocduy_2123110108_app_mobile;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private TextView tvCategoryTitle;
    private RecyclerView recyclerProducts;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCategoryTitle = findViewById(R.id.tvCategoryTitle);
        recyclerProducts = findViewById(R.id.recyclerProducts);

        String category = getIntent().getStringExtra("category");
        tvCategoryTitle.setText("Danh mục: " + category);

        // Tạo danh sách sản phẩm
        productList = new ArrayList<>();
        productList.add(new Product("MacBook Pro 13 M2 chip", 20000000, R.drawable.macbook, "pc"));
        productList.add(new Product("Iphone 13 Pro Max", 27999000, R.drawable.iphone13pro, "phone"));
        productList.add(new Product("Tai Nghe Bluetooth Mèo", 5999000, R.drawable.tainghe, "headphone"));
        productList.add(new Product("PlayStation 5", 12999000, R.drawable.ps5, "gaming"));
        productList.add(new Product("Galaxy S24 Ultra", 27999000, R.drawable.samsungs24, "phone"));
        productList.add(new Product("Tai Nghe P47M", 7999000, R.drawable.tainghep47m, "headphone"));

        // Lọc theo danh mục
        List<Product> filtered = new ArrayList<>();
        for (Product p : productList) {
            if (category.equals("all") || p.getCategory().equalsIgnoreCase(category)) {
                filtered.add(p);
            }
        }

        // Gắn adapter
        ProductAdapter adapter = new ProductAdapter(this, filtered);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerProducts.setAdapter(adapter);
    }
}
