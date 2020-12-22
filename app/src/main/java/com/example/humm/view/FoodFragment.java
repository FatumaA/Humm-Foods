package com.example.humm.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.humm.R;
import com.example.humm.adapters.FoodListAdapter;
import com.example.humm.databinding.FragmentFoodBinding;
import com.example.humm.model.FoodProducts;
import com.example.humm.viewmodels.FoodViewModel;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FoodFragment extends Fragment implements FoodListAdapter.FoodInterface {

    FragmentFoodBinding fragmentFoodBinding;
    private FoodListAdapter foodListAdapter;
    private FoodViewModel foodViewModel;
    private NavController navController;

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFoodBinding = FragmentFoodBinding.inflate(inflater, container, false);
        return fragmentFoodBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodListAdapter = new FoodListAdapter(this);
        fragmentFoodBinding.foodRV.setAdapter(foodListAdapter);
        fragmentFoodBinding.foodRV.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL ));
        fragmentFoodBinding.foodRV.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.HORIZONTAL ));


        foodViewModel = new ViewModelProvider(requireActivity()).get(FoodViewModel.class);
        foodViewModel.getFoodProducts().observe(getViewLifecycleOwner(), new Observer<List<FoodProducts>>() {
            @Override
            public void onChanged(List<FoodProducts> foodProducts) {
                foodListAdapter.submitList(foodProducts);
            }
        });

        navController = Navigation.findNavController(view);
    }

    @Override
    public void addItem(FoodProducts foodProducts) {
        boolean isAdded = foodViewModel.addItemToCart(foodProducts);
        if(isAdded){
            Snackbar.make(requireView(), foodProducts.getName() + "Added to Cart", Snackbar.LENGTH_LONG)
                    .setAction("Check-Out", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            navController.navigate(R.id.action_foodFragment_to_foodDetailFragment);
                        }
                    }).show();
        } else{
            Snackbar.make(requireView(), "Max quantity reached", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(FoodProducts foodProducts) {
        foodViewModel.setFoodProducts(foodProducts);
        navController.navigate(R.id.action_foodFragment_to_foodDetailFragment);

    }
}