package com.example.humm.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.humm.R;
import com.example.humm.databinding.FragmentPlaceOrderBinding;
import com.example.humm.viewmodels.FoodViewModel;

import org.jetbrains.annotations.NotNull;


public class PlaceOrderFragment extends Fragment {

    NavController navController;
    FragmentPlaceOrderBinding fragmentPlaceOrderBinding;
    FoodViewModel foodViewModel;

    public PlaceOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_order, container, false);
        fragmentPlaceOrderBinding = FragmentPlaceOrderBinding.inflate(inflater, container, false);
        return fragmentPlaceOrderBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        foodViewModel = new ViewModelProvider(requireActivity()).get(FoodViewModel.class);

        fragmentPlaceOrderBinding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodViewModel.resetCart();
                navController.navigate(R.id.action_placeOrderFragment_to_foodFragment);
            }
        });
    }
}