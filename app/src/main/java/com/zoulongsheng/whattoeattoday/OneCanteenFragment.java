package com.zoulongsheng.whattoeattoday;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class OneCanteenFragment extends Fragment implements View.OnClickListener{

    private TextView searchText;
    private TextView shopText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_one_canteen,container,false);
        init(view);
        return view;
    }

    public void init(View view){
        searchText = view.findViewById(R.id.search);
        shopText = view.findViewById(R.id.shop);
        TextPaint tp = shopText.getPaint();
        tp.setFakeBoldText(true);
        searchText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search:
                Intent intent = new Intent(getContext(),SearchActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(0,0);
                break;
            default:
                break;
        }
    }
}
