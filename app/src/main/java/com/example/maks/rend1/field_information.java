package com.example.maks.rend1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class field_information extends Activity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    FloatingActionButton fab,fab1,fab2;
    Animation fab_open,fab_close,fab_rotclock,fab_rotanti;
    boolean isOpen = false;
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
        boolean admin = getIntent().getBooleanExtra("admin",true);

        TextView info_name = (TextView)findViewById(R.id.info_name);
        TextView info_price = (TextView)findViewById(R.id.info_price);
        TextView info_tel = (TextView)findViewById(R.id.info_tel);
        TextView info_address = (TextView)findViewById(R.id.info_address);

        info_address.setText(address);
        info_name.setText(name);
        info_price.setText(price);
        info_tel.setText(tel);

        fab = (FloatingActionButton)findViewById(R.id.info_fab);
        fab1 = (FloatingActionButton)findViewById(R.id.info_fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.info_fab2);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fab_rotclock = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fab_rotanti = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlock);

        if(admin){
            fab.setClickable(true);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab1.startAnimation(fab_close);
                    fab2.startAnimation(fab_close);
                    fab.setAnimation(fab_rotanti);
                    fab1.setClickable(false);
                    fab2.setClickable(false);
                    isOpen = false;
                }
                else{
                    fab1.startAnimation(fab_open);
                    fab2.startAnimation(fab_open);
                    fab.setAnimation(fab_rotclock);
                    fab1.setClickable(true);
                    fab2.setClickable(true);
                    isOpen = true;
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.add_field);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Delete field")
                        .setMessage("Are you sure you want to delete this field?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }


}
