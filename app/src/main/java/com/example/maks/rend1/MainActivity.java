package com.example.maks.rend1;


import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean logged = false;//kirdi ma sony tekseredi!!!
    List<Field_list> field_list = new ArrayList<Field_list>();
    ListAdapter customAdapter;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_person_add_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("    Rent-Field");
        setContentView(R.layout.activity_main);

        tabHost = (TabHost)findViewById(R.id.tab_host);
        tabHost.setup();
        TabHost.TabSpec spec1 = tabHost.newTabSpec("like");
        spec1.setIndicator("like");
        spec1.setContent(R.id.tab1);
        TabHost.TabSpec spec2 = tabHost.newTabSpec("price");
        spec2.setIndicator("Price");
        spec2.setContent(R.id.tab2);
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("time");
        spec3.setIndicator("Time");
        spec3.setContent(R.id.tab3);
        tabHost.addTab(spec3);

        TabHost.TabSpec spec4 = tabHost.newTabSpec("map");
        spec4.setIndicator("Map");
        spec4.setContent(R.id.tab4);
        tabHost.addTab(spec4);

        Field_list field1 = new Field_list(1,R.drawable.ic_person_add_black_24dp,"Maks","5000","87759771615","SDU",158,35);
        Field_list field2 = new Field_list(1,R.drawable.ic_person_add_black_24dp,"Maksat","15000","87759771615","SDU",158,35);
        field_list.add(field1);
        field_list.add(field2);
        ListView tab1_list = (ListView)findViewById(R.id.tab1_list);
        customAdapter = new ListAdapter(this, R.layout.list_item,field_list);
        tab1_list.setAdapter(customAdapter);

        ListView tab2_list = (ListView)findViewById(R.id.tab2_list2);
        customAdapter = new ListAdapter(this, R.layout.list_item,field_list);
        tab2_list.setAdapter(customAdapter);

        Button tab2_ok = (Button)findViewById(R.id.tab2_ok);
        final EditText tab2_price1 = (EditText)findViewById(R.id.tab2_price1);
        final EditText tab2_price2 = (EditText)findViewById(R.id.tab2_price2);
        tab2_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Field_list> new_list = new ArrayList<Field_list>();
                int price1 = Integer.parseInt(tab2_price1.getText().toString());
                int price2 = Integer.parseInt(tab2_price2.getText().toString());
                for(int i=0;i<field_list.size();i++){
                    int price = Integer.parseInt(field_list.get(i).getPrice());
                    if(price1 < price && price2 > price){
                        new_list.add(field_list.get(i));
                    }
                }
                ListView tab2_list = (ListView)findViewById(R.id.tab2_list2);
                customAdapter = new ListAdapter(MainActivity.this, R.layout.list_item,new_list);
                tab2_list.setAdapter(customAdapter);
            }
        });
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
                Intent i = new Intent(getApplicationContext(),add_field_java.class);
                getApplicationContext().startActivity(i);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
