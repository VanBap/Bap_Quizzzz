package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bap_quizzzz.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Category List (Son 14/11)
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.categoryList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.categoryList.setAdapter(new CategoryAdapter(Category.list));
        return binding.getRoot();
    }
}