package com.appnucleus.barcodeandqrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("txt1");


        TextView txtview = (TextView) findViewById(R.id.textView3);
        txtview.setText("Hello "+ text);
    }
}
