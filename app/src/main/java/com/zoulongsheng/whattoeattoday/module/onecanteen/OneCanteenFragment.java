package com.zoulongsheng.whattoeattoday.module.onecanteen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zoulongsheng.whattoeattoday.R;
import com.zoulongsheng.whattoeattoday.module.search.SearchActivity;
import com.zoulongsheng.whattoeattoday.adapter.RestaurantAdapter;
import com.zoulongsheng.whattoeattoday.beans.Restaurant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OneCanteenFragment extends Fragment implements View.OnClickListener{

    private TextView searchText;
    private TextView shopText;
    private List<Restaurant> restaurantList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_one_canteen,container,false);
        init(view);
        initRestaurant();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantList);
        recyclerView.setAdapter(restaurantAdapter);
        return view;
    }

    public void init(View view){
        searchText = view.findViewById(R.id.search);
        shopText = view.findViewById(R.id.shop);
        recyclerView = view.findViewById(R.id.recycle_restaurant);
        TextPaint tp = shopText.getPaint();
        tp.setFakeBoldText(true);
        searchText.setOnClickListener(this);
    }

    public void initRestaurant(){
        Restaurant res1 = new Restaurant("阿旺饭馆（华广店）","花都区华广",120,110,10,R.drawable.res1,"60","起送￥24  免配送费  人均￥23","华广饭馆人气第1名","点评高分店铺","30减1  |  60减5  |  80减8","4元无门栏红包");
        restaurantList.add(res1);
        Restaurant res2 = new Restaurant("治国饭馆（华广店）","花都区华广",120,110,10,R.drawable.res2,"30","起送￥14  免配送费  人均￥13","华广饭馆人气第2名","点评高分店铺","20减1  |  40减5  |  52减8","5元无门栏红包");
        restaurantList.add(res2);
        Restaurant res3 = new Restaurant("超佳饭馆（华广店）","花都区华广",120,110,10,R.drawable.res3,"20","起送￥15  配送费3元  人均￥16","华广饭馆人气第3名","点评高分店铺","10减1  |  20减5  |  40减8","3元无门栏红包");
        restaurantList.add(res3);
        restaurantList.add(res1);
        restaurantList.add(res2);
        restaurantList.add(res3);
        restaurantList.add(res1);
        restaurantList.add(res2);
        restaurantList.add(res3);
        restaurantList.add(res1);
        restaurantList.add(res2);
        restaurantList.add(res3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search:
                Intent intent = new Intent(getContext(), SearchActivity.class);
                intent.putExtra("restaurant_list",(Serializable) restaurantList);
                startActivity(intent);
                getActivity().overridePendingTransition(0,0);
                break;
            default:
                break;
        }
    }
}
