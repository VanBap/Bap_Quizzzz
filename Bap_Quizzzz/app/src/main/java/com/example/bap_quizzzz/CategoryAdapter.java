package com.example.bap_quizzzz;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bap_quizzzz.databinding.ListItemBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<Category> list;

    public CategoryAdapter(ArrayList<Category> list){
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tao ra 1 item -> ViewHolder
        //tao ra 1 object cua ViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category item = list.get(position);
        //holder -> ViewHolder can du lieu
        holder.bind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), list.get(holder.getAdapterPosition()).getCategoryName(), Toast.LENGTH_SHORT).show();

                //set topic
                if(holder.getAdapterPosition()==0){
                    HistoryFragment.setTopic("math");
                }else if(holder.getAdapterPosition() == 1){
                    HistoryFragment.setTopic("music");
                }else if(holder.getAdapterPosition() == 2){
                    HistoryFragment.setTopic("CongNghe");
                }

                //pass object
                Bundle args = new Bundle();
                args.putSerializable("object_item", item);

                //dung replace fragment
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                LevelFragment levelFragment = new LevelFragment();
                //set bundle
                levelFragment.setArguments(args);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, levelFragment).addToBackStack(null).commit();

            }
        });
    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ListItemBinding binding;
        CategoryViewHolder(ListItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }


        //dung binding truy cap cac id cua category
        public void bind(Category item){
            binding.nameCategory.setText(item.getCategoryName());
            binding.imageCategory.setImageResource(item.getCategoryImage());


        }

    }

}
