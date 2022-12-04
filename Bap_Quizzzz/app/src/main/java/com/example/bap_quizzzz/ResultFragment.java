package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bap_quizzzz.databinding.FragmentResultBinding;


public class ResultFragment extends Fragment {

    FragmentResultBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater,container,false);

        binding.resultTv.setText(HistoryFragment.getCorrectCount() + "/5");

        return binding.getRoot();
    }
}