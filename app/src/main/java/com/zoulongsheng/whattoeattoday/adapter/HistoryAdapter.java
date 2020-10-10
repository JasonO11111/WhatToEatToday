package com.zoulongsheng.whattoeattoday.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zoulongsheng.whattoeattoday.R;
import com.zoulongsheng.whattoeattoday.beans.History;
import com.zoulongsheng.whattoeattoday.beans.Hot;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    private List<History> mHistoryList;


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView historyText;

        public ViewHolder(View view){
            super(view);
            historyText = view.findViewById(R.id.history_text);
        }

    }

    public HistoryAdapter(List<History> mHistoryList){
        this.mHistoryList = mHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = mHistoryList.get(position);
        holder.historyText.setText(history.getName());
    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }



}
