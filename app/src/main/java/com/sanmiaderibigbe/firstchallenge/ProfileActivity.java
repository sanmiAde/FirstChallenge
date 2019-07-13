package com.sanmiaderibigbe.firstchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle(getString(R.string.profile_text));
    }

    public static Intent newProfileActivity(Context context) {
        return  new Intent(context, ProfileActivity.class);
    }
}
