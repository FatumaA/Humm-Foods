package com.example.humm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.humm.model.CartItem;
import com.example.humm.model.FoodProducts;
import com.example.humm.repos.CartRepo;
import com.example.humm.repos.FoodRepo;

import java.util.List;

public class FoodViewModel extends ViewModel {

    FoodRepo foodRepo = new FoodRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<FoodProducts> mutableFoodProducts = new MutableLiveData<>();
    public LiveData<List<FoodProducts>> getFoodProducts(){

        return foodRepo.getFoodProducts();
    }

    public void setFoodProducts(FoodProducts foodProducts){
        mutableFoodProducts.setValue(foodProducts);
    }
    public LiveData<FoodProducts> getFoodProductsDetail(){
        return  mutableFoodProducts;
    }

    public LiveData<List<CartItem>> getCart(){
        return cartRepo.getCart();
    }
    public boolean addItemToCart(FoodProducts foodProducts){
        return cartRepo.addItemToCart(foodProducts);
    }
    public void removeItemFromCart(CartItem cartItem){
        cartRepo.removeItemFromCart(cartItem);
    }
    public void changeQuantity(CartItem cartItem, int quantity){
        cartRepo.changeQuantity(cartItem, quantity);
    }
    public LiveData<Double> getTotalPrice(){

        return cartRepo.getTotalPrice();
    }
    public void resetCart(){
        cartRepo.initCart();
    }
}
