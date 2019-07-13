package com.sanmiaderibigbe.firstchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(getString(R.string.main_title_bar_text));

        Button myProfileBtn = findViewById(R.id.btn_my_profile);
        Button aboutALCBtn = findViewById(R.id.btn_about_alc);

        myProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = ProfileActivity.newProfileActivity(MainActivity.this);
                startActivity(intent);
            }
        });

        aboutALCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AboutALCActivity.newAboutALCActivity(MainActivity.this);
                startActivity(intent);
            }
        });

    }
}
