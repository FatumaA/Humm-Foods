package com.example.humm.model;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class CartItem {
    private FoodProducts foodProducts;
    private  int quantity;

    public CartItem(FoodProducts foodProducts, int quantity) {
        this.foodProducts = foodProducts;
        this.quantity = quantity;
    }

    public FoodProducts getFoodProducts() {
        return foodProducts;
    }

    public void setFoodProducts(FoodProducts foodProducts) {
        this.foodProducts = foodProducts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "foodProducts=" + foodProducts +
                ", quantity=" + quantity +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return getQuantity() == cartItem.getQuantity() &&
                getFoodProducts().equals(cartItem.getFoodProducts());
    }
    @BindingAdapter("android:setVal")
    public static void getSelectedSpinnerValue(Spinner spinner, int quantity){
        spinner.setSelection(quantity -1, true);
    }
    public static DiffUtil.ItemCallback<CartItem> itemCallback = new DiffUtil.ItemCallback<CartItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}
