package com.zoulongsheng.whattoeattoday.module.search;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zoulongsheng.whattoeattoday.module.index.MainActivity;
import com.zoulongsheng.whattoeattoday.R;
import com.zoulongsheng.whattoeattoday.adapter.RestaurantAdapter;
import com.zoulongsheng.whattoeattoday.beans.Restaurant;

import java.util.ArrayList;
import android.os.SystemClock;
public class SearchActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {


    private ImageView backImg;
    private EditText searchEdit;
    private TextView search_btn;
    private String searchStr = "";
    private ProgressBar progressBar;
    private TextView not_foundText;
    private RecyclerView recyclerView;
    ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    progressBar.setVisibility(View.GONE);
                    not_foundText.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
                    recyclerView.setLayoutManager(layoutManager);
                    RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants);
                    recyclerView.setAdapter(restaurantAdapter);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
    }

    private void init(){
        backImg = findViewById(R.id.back);
        searchEdit = findViewById(R.id.search_edit);
        search_btn = findViewById(R.id.search_btn);
        progressBar = findViewById(R.id.loading);
        not_foundText = findViewById(R.id.not_found);
        recyclerView = findViewById(R.id.search_recycle_restaurant);
        searchEdit.setFocusable(true);
        searchEdit.setFocusableInTouchMode(true);
        searchEdit.requestFocus();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        backImg.setOnClickListener(this);
        searchEdit.addTextChangedListener(this);
        search_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                break;
            case R.id.search_btn:
                search();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        searchStr = searchEdit.getText().toString();
    }

    public void search(){
        restaurants.clear();

        progressBar.setVisibility(View.GONE);
        not_foundText.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager) getBaseContext().getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        if(searchStr.equals("")){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(SearchActivity.this);
            alertDialog.setTitle("提示");
            alertDialog.setMessage("请先输入内容，再进行搜索！");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }else{
            progressBar.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = getIntent();
                    ArrayList<Restaurant> list = (ArrayList<Restaurant>)intent.getSerializableExtra("restaurant_list");
                    Restaurant restaurant = null;
                    for(int i = 0;i<list.size();i++){
                        restaurant = list.get(i);
                        if(restaurant.getName().indexOf(searchStr) != -1){
                            restaurants.add(restaurant);
                            Log.d("zls","1");
                        }
                    }
                    SystemClock.sleep(2000);
                    Message message = new Message();
                    if(restaurants.size() == 0){
                        message.what = 0;
                    }else{
                        message.what = 1;
                    }
                    handler.sendMessage(message);
                }
            }).start();
        }
    }



}