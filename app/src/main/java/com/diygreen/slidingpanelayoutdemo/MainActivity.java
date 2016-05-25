package com.diygreen.slidingpanelayoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.diygreen.slidingpanelayoutdemo.simple.SimpleUse1Activity;
import com.diygreen.slidingpanelayoutdemo.simple.SimpleUse2Activity;
import com.diygreen.slidingpanelayoutdemo.slideclose.NextActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                overlay(SimpleUse1Activity.class);
                break;
            case R.id.btn_test2:
                overlay(SimpleUse2Activity.class);
                break;
            case R.id.btn_test3:
                overlay(NextActivity.class);
                break;
        }
    }

    private void overlay(Class<? extends Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
