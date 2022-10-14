package com.example.homeworkapplication;

import java.lang.Thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private TextView mTextView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextView = (TextView)findViewById(R.id.textview);
        Intent mIntent = getIntent();
        Bundle mBundle = mIntent.getExtras();
        message = mBundle.getCharSequence("msg").toString();
        mTextView.setText(message);
        mBundle.putCharSequence("return_message", "return message: "+message);
        mIntent.putExtras(mBundle);
        setResult(RESULT_OK, mIntent);

        Log.d(TAG, "onCreate out");
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