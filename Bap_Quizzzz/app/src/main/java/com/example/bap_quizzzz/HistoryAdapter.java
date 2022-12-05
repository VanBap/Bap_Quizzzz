package com.example.bap_quizzzz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bap_quizzzz.databinding.ListHistoryBinding;
import com.example.bap_quizzzz.databinding.ListItemBinding;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{


    Context context;
    ArrayList<History> list;
    public HistoryAdapter(Context context, ArrayList<History> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_history, null);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History item = list.get(position);



        holder.result.setText(item.correctCount + "/5");
        holder.category.setText(item.topic);
        holder.level.setText(item.level);
        holder.date.setText(item.initTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder{
        TextView result;
        TextView category;
        TextView level;
        TextView date;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            result = itemView.findViewById(R.id.result_his);
            category = itemView.findViewById(R.id.category_his);
            level = itemView.findViewById(R.id.level_his);
            date = itemView.findViewById(R.id.date_his);
        }

    }
}
