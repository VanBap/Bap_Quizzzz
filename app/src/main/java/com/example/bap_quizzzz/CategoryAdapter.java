package com.example.bap_quizzzz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        //Gan gia tri cho cac View cua Item
        ImageView imageView;
        TextView textView;

        //dung binding
        public void bind(Category item){
            binding.nameCategory.setText(item.getCategoryName());
            binding.imageCategory.setImageResource(item.getCategoryImage());
        }

        /*public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageCategory);
            textView = itemView.findViewById((R.id.nameCategory));
        }*/
    }
}
