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
import com.example.humm.adapters.CartListAdapter;
import com.example.humm.databinding.FragmentCartBinding;
import com.example.humm.model.CartItem;
import com.example.humm.repos.CartRepo;
import com.example.humm.viewmodels.FoodViewModel;

import java.util.List;


public class CartFragment extends Fragment implements CartListAdapter.CartInterface {


    FoodViewModel foodViewModel;
    FragmentCartBinding fragmentCartBinding;
    NavController navController;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding = FragmentCartBinding.inflate(inflater, container, false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        CartListAdapter cartListAdapter = new CartListAdapter(this);
        fragmentCartBinding.cartRV.setAdapter(cartListAdapter);
        fragmentCartBinding.cartRV.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        foodViewModel = new ViewModelProvider(requireActivity()).get(FoodViewModel.class);
        foodViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {


            @Override
            public void onChanged(List<CartItem> cartItems) {
                cartListAdapter.submitList(cartItems);

                fragmentCartBinding.placeOrderButton.setEnabled(cartItems.size() > 0);
            }
        });

        foodViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                fragmentCartBinding.orderTotalTextView.setText("Total: $ " + aDouble.toString());
            }
        });

        fragmentCartBinding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cartFragment2_to_placeOrderFragment);
            }
        });

    }

    @Override
    public void deleteItem(CartItem cartItem) {
        foodViewModel.removeItemFromCart(cartItem);
    }

    @Override
    public void changeQuantity(CartItem cartItem, int quantity) {
        foodViewModel.changeQuantity(cartItem, quantity);
    }
}