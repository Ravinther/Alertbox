package com.example.ux.alertbox;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Ravi on 6/24/2016.
 */
public class listviewdialog extends Activity {
    Button btn;
    final Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertbox=new AlertDialog.Builder(context)
                        .setTitle("Enter The Details")
                        .setIcon(R.drawable.mute);
                final EditText editText=new EditText(context);
                LinearLayout layout=new LinearLayout(context);
                editText.setHint("Enter The Name");
                layout.addView(editText);
                final EditText editText1=new EditText(context);
                editText1.setHint("Enter the Phone Number");
                layout.addView(editText1);
                alertbox.setView(layout);
                alertbox.setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), listview.class);
                                Bundle bundle = getIntent().getExtras();
                                intent.putExtra("name", editText.getText().toString());
                                intent.putExtra("number", editText1.getText().toString());
                                startActivity(intent);
                            }
                        });
                AlertDialog alertDialog=alertbox.create();
                alertDialog.show();

            }
        });
    }
}
