package com.example.nguyenngocduy_2123110108_app_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    private Context context;
    private List<CartItem> cartItems;
    private Runnable updateTotalCallback;

    public CartAdapter(Context context, List<CartItem> cartItems, Runnable updateTotalCallback) {
        this.context = context;
        this.cartItems = cartItems;
        this.updateTotalCallback = updateTotalCallback;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView img;
        TextView name, price, quantity;
        Button btnPlus, btnMinus, btnDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_cart_adapter, parent, false);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.imgCart);
            holder.name = convertView.findViewById(R.id.txtName);
            holder.price = convertView.findViewById(R.id.txtPrice);
            holder.quantity = convertView.findViewById(R.id.txtQuantity);
            holder.btnPlus = convertView.findViewById(R.id.btnPlus);
            holder.btnMinus = convertView.findViewById(R.id.btnMinus);
            holder.btnDelete = convertView.findViewById(R.id.btnDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CartItem item = cartItems.get(position);

        holder.img.setImageResource(item.getImageResId());
        holder.name.setText(item.getName());
        holder.price.setText("Giá: " + item.getPrice() + "đ");
        holder.quantity.setText(String.valueOf(item.getQuantity()));

        // Tăng số lượng
        holder.btnPlus.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyDataSetChanged();
            updateTotalCallback.run();
        });

        // Giảm số lượng (tối thiểu 1)
        holder.btnMinus.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                notifyDataSetChanged();
                updateTotalCallback.run();
            }
        });

        // Xóa sản phẩm
        holder.btnDelete.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyDataSetChanged();
            updateTotalCallback.run();
        });

        return convertView;
    }
}
