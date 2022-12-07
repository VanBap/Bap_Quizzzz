package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bap_quizzzz.databinding.FragmentLevelBinding;
import com.example.bap_quizzzz.databinding.FragmentQuestionBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LevelFragment extends Fragment {
    FragmentLevelBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLevelBinding.inflate(inflater,container,false);
        //truyen object tu home fragment sang level fragment
        Bundle args = getArguments(); // NHẬN
        Category item = (Category) args.getSerializable("object_item");
        binding.catName.setText(item.getCategoryName()); // HIỆN THỊ TÊN CHỦ ĐỀ ĐÃ CHỌN


        return binding.getRoot();

    }


}