package com.appnucleus.barcodeandqrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    private Session session;//global variable
    private TextView greetingTextView;
    UserActivity ua = new UserActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Context cntx = getApplicationContext();
       // session = new Session(cntx);
        //String temp = session.getusename();

        String email= ua.getemailname();

        setContentView(R.layout.activity_result);
        //session.getusename();
        greetingTextView = (TextView) findViewById(R.id.textView);
        greetingTextView.setText("Hello "+email);


    }


}
