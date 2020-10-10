package com.zoulongsheng.whattoeattoday.module.threecanteen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.zoulongsheng.whattoeattoday.R;

public class ThreeCanteenFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_three_canteen,container,false);
        return view;
    }

}
