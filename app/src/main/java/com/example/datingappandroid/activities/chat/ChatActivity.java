package com.example.datingappandroid.activities.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.datingappandroid.R;

public class ChatActivity extends AppCompatActivity {
    private Toolbar chatToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide phone bar (time, battery,...)
        hideHeaderBar();
        setContentView(R.layout.activity_chat_activity);

        // chat bar
        chatToolbar = findViewById(R.id.chats_appbar);
        setSupportActionBar(chatToolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            // Inflate and set the custom view for the toolbar
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View customView = layoutInflater.inflate(R.layout.appbar_chat, null);
            actionBar.setCustomView(customView);
        }
    }
    private void hideHeaderBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
