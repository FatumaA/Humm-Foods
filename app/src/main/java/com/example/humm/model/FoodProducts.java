package com.example.humm.model;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;


import java.util.Objects;

public class FoodProducts {
    private String id;
    private String name;
    private String desc;
    private double price;
    private boolean isAvailable;
    private String imageUrl;

    public FoodProducts(String id, String name, String desc, double price,
                        boolean isAvailable, String imageUrl) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "FoodProducts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodProducts foodProducts = (FoodProducts) o;
        return Double.compare(foodProducts.getPrice(), getPrice()) == 0 &&
                isAvailable() == foodProducts.isAvailable() &&
                getId().equals(foodProducts.getId()) &&
                getName().equals(foodProducts.getName()) &&
                getDesc().equals(foodProducts.getDesc()) &&
                getImageUrl().equals(foodProducts.getImageUrl());
    }



    public static DiffUtil.ItemCallback<FoodProducts> itemCallback = new DiffUtil.ItemCallback<FoodProducts>() {
        @Override
        public boolean areItemsTheSame(@NonNull FoodProducts oldItem, @NonNull FoodProducts newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull FoodProducts oldItem, @NonNull FoodProducts newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:foodImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .fitCenter()
                .into(imageView);
    }


}

