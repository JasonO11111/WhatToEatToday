package com.zoulongsheng.whattoeattoday.module.fourcanteen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.zoulongsheng.whattoeattoday.R;

public class FourCanteenFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_four_canteen,container,false);
        return view;
    }

}
