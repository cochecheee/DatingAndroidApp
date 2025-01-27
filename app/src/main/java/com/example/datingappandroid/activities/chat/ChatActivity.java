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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datingappandroid.R;
import com.example.datingappandroid.adapters.MessageAdapter;
import com.example.datingappandroid.models.dto.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private Toolbar chatToolbar;
    private RecyclerView messageList_ReCyVw;
    private LinearLayoutManager linearLayoutManager;
    // fake data
    public static List<Message> generateFakeMessages() {
        List<Message> fakeMessages = new ArrayList<>();

        // Thêm các tin nhắn giả vào danh sách
        fakeMessages.add(new Message("Hello!", "10:00 AM", true, "user1"));
        fakeMessages.add(new Message("Hi there!", "10:05 AM", false, "user2"));
        fakeMessages.add(new Message("How are you?", "10:10 AM", true, "user1"));
        fakeMessages.add(new Message("I'm good, thanks!", "10:15 AM", false, "user2"));
        fakeMessages.add(new Message("What are you up to?", "10:20 AM", true, "user1"));
        fakeMessages.add(new Message("Just working on a project.", "10:25 AM", false, "user2"));
        fakeMessages.add(new Message("Sounds interesting!", "10:30 AM", true, "user1"));
        fakeMessages.add(new Message("Yeah, it's quite challenging.", "10:35 AM", false, "user2"));

        return fakeMessages;
    }
    List<Message> fakeMessages = generateFakeMessages();

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

        // todo 1: initilize sample data (messages)
        // todo 2: create adapter passing sample data
        messageList_ReCyVw = findViewById(R.id.message_list);
        MessageAdapter adapter = new MessageAdapter(fakeMessages);
        // todo 3: attach adapter to recycle view
        messageList_ReCyVw.setAdapter(adapter);
        // todo 4: set layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        messageList_ReCyVw.setLayoutManager(linearLayoutManager);
        messageList_ReCyVw.setHasFixedSize(true);
    }
    private void hideHeaderBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
