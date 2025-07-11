package com.example.nguyenngocduy_2123110108_app_mobile;

public class Product {
    private String name;
    private int price;
    private int imageResId;
    private String category;

    public Product(String name, int price, int imageResId , String category) {
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getCategory() {
        return category;
    }
}
