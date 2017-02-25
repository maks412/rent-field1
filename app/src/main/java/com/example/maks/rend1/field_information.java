package com.example.maks.rend1;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        int id = getIntent().getIntExtra("id",0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String tel = getIntent().getStringExtra("tel");
        String address = getIntent().getStringExtra("address");

        TextView info_name = (TextView)findViewById(R.id.info_name);
        TextView info_price = (TextView)findViewById(R.id.info_price);
        TextView info_tel = (TextView)findViewById(R.id.info_tel);
        TextView info_address = (TextView)findViewById(R.id.info_address);

        info_address.setText(address);
        info_name.setText(name);
        info_price.setText(price);
        info_tel.setText(tel);
    }
}
