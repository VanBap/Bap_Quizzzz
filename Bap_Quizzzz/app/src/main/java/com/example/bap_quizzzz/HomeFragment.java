package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bap_quizzzz.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment{
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Category List (Son + Van 14/11)
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.categoryList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.categoryList.setAdapter(new CategoryAdapter(Category.list));

        return binding.getRoot();
    }
}