package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;import android.graphics.Bitmap;
import android.widget.Switch;
import android.widget.Toast;


public class ListItemsActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "MainActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    public void onActivityResult(int requestCode,int responseCode, Intent data){
        super.onActivityResult(requestCode,responseCode,data);
        ImageButton button = findViewById(R.id.imgbutton);

        if(requestCode==REQUEST_IMAGE_CAPTURE && responseCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            button.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        ImageButton button = findViewById(R.id.imgbutton);

        Switch sw = findViewById(R.id.sw);

        CheckBox cb = findViewById(R.id.checkb);

        cb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(cb.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                    builder.setMessage("Do you want to finish the activity");

                    builder .setTitle("Alert");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response", "Here is my response");
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    finish();
                                }
                            });
                    builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    builder.show();
                }else{

                }
            }
        });

        sw.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(sw.isChecked()){
                    CharSequence text = "Switch is On";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext() , text, duration);
                    toast.show();
                }else{
                    CharSequence text = "Switch is Off";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext() , text, duration);
                    toast.show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");

    }
}