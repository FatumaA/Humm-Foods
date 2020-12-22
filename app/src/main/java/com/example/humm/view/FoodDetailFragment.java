package com.example.humm.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.humm.R;
import com.example.humm.databinding.FragmentFoodDetailBinding;
import com.example.humm.viewmodels.FoodViewModel;

import static com.example.humm.databinding.FragmentFoodDetailBinding.*;


public class FoodDetailFragment extends Fragment {

    FragmentFoodDetailBinding fragmentFoodDetailBinding;
    FoodViewModel foodViewModel;

    public FoodDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFoodDetailBinding = inflate(inflater, container, false);
        return fragmentFoodDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodViewModel = new ViewModelProvider(requireActivity()).get(FoodViewModel.class);
        fragmentFoodDetailBinding.setFoodViewModel(foodViewModel);
    }
}