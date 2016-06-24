package com.example.ux.alertbox;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ravi on 6/24/2016.
 */
public class asynalert extends Activity {
    Button btn;
    final  Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AlertDialog.Builder alertbox=new AlertDialog.Builder(context)
                       .setIcon(R.drawable.mute)
                       .setTitle("Enter the Number");
                      final EditText txt=new EditText(context);
                      alertbox.setView(txt);
                        alertbox.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getBaseContext(),"You Have clicked Ok",Toast.LENGTH_LONG).show();
                                        new RegisterTask().execute();
                                    }
                                })
                                .setNegativeButton("Cancal",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getBaseContext(),"You have Clicked No",Toast.LENGTH_LONG).show();
                                            }
                                        });
                AlertDialog alertDialog=alertbox.create();
                alertDialog.show();

            }
        });
    }
    private class RegisterTask extends AsyncTask<Void, Void, Boolean> {
        private final ProgressDialog dialog = new ProgressDialog(asynalert.this);

        protected void onPreExecute() {
            this.dialog.setMessage("Signing in...");
            this.dialog.show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            dialog.dismiss();
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for (int i=0;i<5;i++)
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                    Thread.interrupted();
            }
            return true;
        }

    }
}
