package com.zoulongsheng.whattoeattoday.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zoulongsheng.whattoeattoday.R;
import com.zoulongsheng.whattoeattoday.beans.Hot;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder>{

    private List<Hot> mHotList;


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView hotText;

        public ViewHolder(View view){
            super(view);
            hotText = view.findViewById(R.id.hot_text);
        }

    }

    public HotAdapter(List<Hot> mHotList){
        this.mHotList = mHotList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hot hot = mHotList.get(position);
        holder.hotText.setText(hot.getName());
    }

    @Override
    public int getItemCount() {
        return mHotList.size();
    }



}
