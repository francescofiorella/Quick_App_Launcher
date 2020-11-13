package com.example.quicklauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // imposta il testo passato da MainActivity
        if (getIntent().hasExtra("org.example.quicklauncher.SOMETHING")){
            TextView tv = (TextView)findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("org.example.quicklauncher.SOMETHING");
            tv.setText(text);
        }
    }
}