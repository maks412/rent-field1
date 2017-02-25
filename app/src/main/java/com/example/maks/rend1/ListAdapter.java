package com.example.maks.rend1;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Maks on 25.02.2017.
 */

public class ListAdapter extends ArrayAdapter<Field_list> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<Field_list> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_item, null);
        }

        final Field_list p = getItem(position);

        if (p != null) {
            ImageView imageView = (ImageView)v.findViewById(R.id.list_img);
            TextView name = (TextView)v.findViewById(R.id.list_name);
            TextView address = (TextView)v.findViewById(R.id.list_address);
            TextView tel = (TextView)v.findViewById(R.id.list_tel);
            TextView price = (TextView)v.findViewById(R.id.list_price);

            imageView.setImageResource(p.getImg());
            name.setText("Название: "+p.getName());
            address.setText("Адрес: "+p.getAddress());
            tel.setText("Тел: "+p.getTel());
            price.setText("Цена: "+p.getPrice()+" тг");


        }
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(),p.getName(),Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getContext(), field_information.class);
                intent.putExtra("id",p.getId());
                intent.putExtra("name",p.getName());
                intent.putExtra("tel",p.getTel());
                intent.putExtra("address",p.getAddress());
                intent.putExtra("price",p.getPrice());

                getContext().startActivity(intent);
            }
        });
        return v;
    }

}
