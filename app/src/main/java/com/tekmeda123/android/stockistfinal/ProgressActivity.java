package com.tekmeda123.android.stockistfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProgressActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
    }

    public void MakeYourWay(View view) {
        Intent i =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
