package com.example.quicklauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // definizione button
        Button secondActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
        // onClick
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // crea un intent che passa alla secondActivity (definizione intent)
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                // passa informazioni alla secondActivity, name specifica l'id dell'informazione
                startIntent.putExtra("org.example.quicklauncher.SOMETHING", "HELLO WORLD!");
                // esegui l'intent
                startActivity(startIntent);
            }
        });

        // Attempt to launch an activity outside our app
        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // creo una stringa con l'url
                String google = "http://www.google.com";
                // Universal Risource Identifier
                Uri webaddress = Uri.parse(google);

                // l'intent va fuori dall'app
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                // controlla se c'è un browser (se c'è una lista di cose che possono risolvere l'activity)
                if (gotoGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}