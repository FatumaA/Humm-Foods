package com.example.humm.adapters;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humm.databinding.FoodRowBinding;
import com.example.humm.model.FoodProducts;

public class FoodListAdapter extends ListAdapter<FoodProducts, FoodListAdapter.FoodViewHolder> {

    FoodInterface foodInterface;

    public FoodListAdapter(FoodInterface foodInterface) {
        super(FoodProducts.itemCallback);
        this.foodInterface = foodInterface;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FoodRowBinding foodRowBinding = FoodRowBinding.inflate(layoutInflater, parent, false);
        foodRowBinding.setFoodInterface(foodInterface);
        return new FoodViewHolder(foodRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodProducts foodProducts = getItem(position);
        holder.foodRowBinding.setFoodProducts(foodProducts);
        holder.foodRowBinding.executePendingBindings();

    }

    class FoodViewHolder extends RecyclerView.ViewHolder{



        FoodRowBinding foodRowBinding;
        public FoodViewHolder(FoodRowBinding binding) {
            super(binding.getRoot());
            this.foodRowBinding = binding;

        }
    }
    public interface FoodInterface{
        void addItem(FoodProducts foodProducts);
        void onItemClick(FoodProducts foodProducts);
    }
}

