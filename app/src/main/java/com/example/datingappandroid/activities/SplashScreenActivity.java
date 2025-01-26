package com.example.datingappandroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datingappandroid.activities.chat.ChatActivity;
import com.example.datingappandroid.activities.user.ProfileActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sang SignUpActivity
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
        finish();
    }

}