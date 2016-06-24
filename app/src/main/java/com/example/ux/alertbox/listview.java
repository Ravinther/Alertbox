package com.example.ux.alertbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Ravi on 6/24/2016.
 */
public class listview extends Activity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listView=(ListView)findViewById(R.id.listview1);
        Bundle extras=getIntent().getExtras();
        String[] values=new String[2];
        String name1,number,DOB;
        name1=extras.getString("name");
        number=extras.getString("number");
        values[0]=name1;
        values[1]=number;

        ArrayAdapter<String> list=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        listView.setAdapter(list);
    }
}
