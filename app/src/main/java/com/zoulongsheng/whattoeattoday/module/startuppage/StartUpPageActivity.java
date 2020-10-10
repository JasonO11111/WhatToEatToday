package com.zoulongsheng.whattoeattoday.module.startuppage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.zoulongsheng.whattoeattoday.module.index.MainActivity;
import com.zoulongsheng.whattoeattoday.R;

import java.util.Timer;
import java.util.TimerTask;

public class StartUpPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_page);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TimerTask delayTask = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(StartUpPageActivity.this, MainActivity.class);
                startActivity(mainIntent);
                StartUpPageActivity.this.finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(delayTask,2000);     //延时两秒执行 run 里面的操作
    }
}