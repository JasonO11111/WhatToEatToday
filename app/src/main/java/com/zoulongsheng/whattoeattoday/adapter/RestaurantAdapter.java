package com.zoulongsheng.whattoeattoday.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zoulongsheng.whattoeattoday.R;
import com.zoulongsheng.whattoeattoday.beans.Restaurant;
import com.zoulongsheng.whattoeattoday.module.restaurant.RestaurantActivity;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurant> mRestaurantList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView restaurantImg;
        TextView restaurantName;
        ImageView restaurantStar;
        TextView restaurantAssess;
        TextView restaurantSale;
        TextView restaurantTime;
        TextView restaurantSend;
        TextView restaurantDescrition1;
        TextView restaurantDescrition2;
        TextView restaurantDiscount1;
        TextView restaurantDiscount2;
        ImageView pop_img;

        public ViewHolder(View view){
            super(view);
            restaurantImg = view.findViewById(R.id.restaurant_img);
            restaurantName = view.findViewById(R.id.restaurant_name);
            restaurantStar = view.findViewById(R.id.restaurant_star);
            restaurantAssess = view.findViewById(R.id.restaurant_assess);
            restaurantSale = view.findViewById(R.id.restaurant_sale);
            restaurantTime = view.findViewById(R.id.restaurant_time);
            restaurantSend = view.findViewById(R.id.restaurant_send);
            restaurantDescrition1 = view.findViewById(R.id.restaurant_descrition1);
            restaurantDescrition2 = view.findViewById(R.id.restaurant_descrition2);
            restaurantDiscount1 = view.findViewById(R.id.restaurant_discount1);
            restaurantDiscount2 = view.findViewById(R.id.restaurant_discount2);
            pop_img = view.findViewById(R.id.pop_img);
        }

    }

    public RestaurantAdapter(List<Restaurant> mRestaurantList){
        this.mRestaurantList = mRestaurantList;
    }

    @NonNull
    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.pop_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getPosition();
                Restaurant restaurant = mRestaurantList.get(position);
                Toast.makeText(v.getContext(),"you click pop img"+restaurant.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getPosition();
                Restaurant restaurant = mRestaurantList.get(position);
                Intent intent = new Intent(v.getContext(), RestaurantActivity.class);
                v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(),"you click item view"+restaurant.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        Restaurant restaurant = mRestaurantList.get(position);
        holder.restaurantImg.setImageResource(restaurant.getImg());
        holder.restaurantName.setText(restaurant.getName());
        holder.restaurantStar.setImageResource(R.drawable.star);
        int goodPeople = restaurant.getGoodReputation();
        int badPeople = restaurant.getBadReputation();
        double assess = goodPeople*1.0/(badPeople+goodPeople);
        assess *= 100;
        holder.restaurantAssess.setText("4.7");
        holder.restaurantSale.setText("月售"+restaurant.getBadReputation()+restaurant.getGoodReputation());
        holder.restaurantTime.setText(restaurant.getWaitTime()+"分钟");
        holder.restaurantSend.setText(restaurant.getSend());
        holder.restaurantDescrition1.setText(restaurant.getDescrition1());
        holder.restaurantDescrition2.setText(restaurant.getDescrition2());
        holder.restaurantDiscount1.setText(restaurant.getDiscount1());
        holder.restaurantDiscount2.setText(restaurant.getDiscount2());
    }

    @Override
    public int getItemCount() {
        return mRestaurantList.size();
    }

}
