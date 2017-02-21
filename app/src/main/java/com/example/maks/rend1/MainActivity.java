package com.example.maks.rend1;


import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.zip.Inflater;

import static android.R.string.ok;

public class MainActivity extends AppCompatActivity {
    boolean logged = false;//kirdi ma sony tekseredi!!!
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_person_add_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        getSupportActionBar().setTitle("    Rent-Field");
        setContentView(R.layout.activity_main);
        if(logged){
            getSupportActionBar().setLogo(R.drawable.ic_search_black_24dp);
        }



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Do stuff
                final Dialog dialog = new Dialog(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.dialog_registration, null);
                dialog.setContentView(layout);
                //dialog.setContentView(R.layout.dialog_registration);
                dialog.setTitle("Регистрация");
                EditText reg_login = (EditText)dialog.findViewById(R.id.reg_login);
                EditText reg_tel = (EditText)dialog.findViewById(R.id.reg_tel);

                EditText reg_mail = (EditText)dialog.findViewById(R.id.reg_mail);
                Button reg_user = (Button)dialog.findViewById(R.id.button_user);
                Button reg_admin = (Button)dialog.findViewById(R.id.button_admin);



                reg_user.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.dialog_registration2, null);
                        dialog.setContentView(layout);
                        Button reg_ok = (Button)dialog.findViewById(R.id.button_reg);
                        reg_ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                });
                reg_admin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.dialog_registration2, null);
                        dialog.setContentView(layout);
                        Button reg_ok = (Button)dialog.findViewById(R.id.button_reg);
                        reg_ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        ///////////////////////////////REGISTRATION PART
                    }
                });
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        final MenuItem enter = menu.findItem(R.id.enter);
        final MenuItem search = menu.findItem(R.id.search);
        if(logged){
            enter.setVisible(false);
        }

        enter.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final Dialog dialog = new Dialog(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.dialog_login, null);
                dialog.setContentView(layout);
                //dialog.setContentView(R.layout.dialog_login);
                dialog.setTitle("Войти");
                EditText log = (EditText)dialog.findViewById(R.id.login_login);
                EditText pass = (EditText)dialog.findViewById(R.id.login_pass);
                Button ok = (Button)dialog.findViewById(R.id.button_login);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logged = true;
                        dialog.dismiss();

                    }
                });
                dialog.show();
                /////////////////////////////////////////LOGIN PART
                return false;
            }
        });

        search.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(MainActivity.this,field_information.class);
                startActivity(i);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
