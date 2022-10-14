package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context context = this;
    private EditText edittext;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.edittext);
        textview = (TextView) findViewById(R.id.textview);
        Button click = (Button) findViewById(R.id.button);
        click.setBackgroundColor(Color.parseColor("#FFbdbdbd"));
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick in");
                String message= "";
                Intent mIntent = new Intent(MainActivity.this, SecondActivity.class);

                message = edittext.getText().toString();
                if(message.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_LONG).show();
                }
                else {
                    Bundle mBundle = new Bundle();
                    mBundle.putCharSequence("msg", message);
                    mIntent.putExtras(mBundle);

                    edittext.setText("");
                    edittext.clearFocus();

                    startActivityForResult(mIntent, 1);
                }
                Log.d(TAG, "onClick out");
            }
        });
        Log.d(TAG, "onCreate out");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult in");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // SearchAddressInfo info = (SearchAddressInfo) data.getParcelableExtra("position");
            String return_message = data.getStringExtra("return_message");
            Log.d(TAG, "return message: " + return_message);
            textview.setText(return_message);
        }
        Log.d(TAG, "onActivityResult out");
    }



    @Override
    protected void onStart() {
        Log.d(TAG, "onStart in");
        super.onStart();
        Log.d(TAG, "onStart out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume in");
        super.onResume();
        Log.d(TAG, "onResume out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause in");
        super.onPause();
        Log.d(TAG, "onPause out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop in");
        super.onStop();
        Log.d(TAG, "onStop out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy in");
        super.onDestroy();
        Log.d(TAG, "onDestroy out");
    }
}