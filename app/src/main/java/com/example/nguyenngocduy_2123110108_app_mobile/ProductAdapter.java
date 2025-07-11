package com.example.nguyenngocduy_2123110108_app_mobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;
    private final Context context;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.productList = products;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;
        Button btnView, btnAddToCart;

        public ProductViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            btnView = itemView.findViewById(R.id.btn_view);
            btnAddToCart = itemView.findViewById(R.id.btn_add_to_cart);
        }
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.image.setImageResource(p.getImageResId());
        holder.name.setText(p.getName());
        String formattedPrice = formatCurrency(p.getPrice());
        holder.price.setText(formattedPrice);

        // Sự kiện nút "Xem"
        holder.btnView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", p.getName());
            intent.putExtra("price", formattedPrice);
            intent.putExtra("image", p.getImageResId());
            context.startActivity(intent);
        });

        // Sự kiện nút "Thêm giỏ"
        holder.btnAddToCart.setOnClickListener(v -> {
            CartItem item = new CartItem(p.getName(), p.getPrice(), 1, p.getImageResId());
            CartManager.cartItems.add(item);
            Toast.makeText(context, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        });
    }

    private String formatCurrency(int amount) {
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(amount);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
