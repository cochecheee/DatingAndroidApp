package com.example.datingappandroid.activities.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datingappandroid.R;
import com.example.datingappandroid.adapters.MessageAdapter;
import com.example.datingappandroid.models.Message;

import java.util.ArrayList;
import java.util.List;
import android.text.TextUtils;
import android.widget.Toast;


public class ChatActivity extends AppCompatActivity {
    private Toolbar chatToolbar;
    /* render list messages*/
    private RecyclerView messageList_ReCyVw;
    private LinearLayoutManager linearLayoutManager;
    private MessageAdapter messageAdapter;
    /* sending message input and button*/
    private ImageView send_message;
    private EditText input_user_message;

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
        displayChatBar();
        // render list message
        renderDataToRecycleView();
        // send messages
        // todo 1: binding sending button to activity
        send_message = findViewById(R.id.c_send_message_BTN);
        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }
    /*************************************************/
    private void sendMessage() {
        input_user_message = findViewById(R.id.c_input_message);

        // todo 1.1: get message from input field
        String message = input_user_message.getText().toString();

        if (TextUtils.isEmpty(message)) {
            Toast.makeText(ChatActivity.this, "Please type a message", Toast.LENGTH_SHORT).show();
        } else {
            // todo 2: create new message instance
            Message newMessage = new Message();
            newMessage.setFrom("user1"); // "user1"
            newMessage.setMessage(message);
            newMessage.setSeen(false);
            newMessage.setTime("11:11 PM");
            // todo 3: add message to database
            fakeMessages.add(newMessage);
            // todo 4: notify adapter about changing data
            messageAdapter.notifyDataSetChanged();
            // todo 5: reset input field
            input_user_message.setText("");
            // todo 6: scrolling to latest message
            messageList_ReCyVw.smoothScrollToPosition(fakeMessages.size() - 1);
        }
    }
    private void displayChatBar() {
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
    private void renderDataToRecycleView() {
        // todo 1: initilize sample data (messages)
        // todo 2: create adapter passing sample data
        messageList_ReCyVw = findViewById(R.id.message_list);
        messageAdapter = new MessageAdapter(fakeMessages);
        // todo 3: attach adapter to recycle view
        messageList_ReCyVw.setAdapter(messageAdapter);
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
