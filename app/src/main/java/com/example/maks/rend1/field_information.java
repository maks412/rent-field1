package com.example.maks.rend1;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class field_information extends Activity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_information);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        int [] images = {R.drawable.a,R.drawable.a146};
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
