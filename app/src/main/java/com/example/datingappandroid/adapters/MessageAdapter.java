package com.example.datingappandroid.adapters;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.datingappandroid.models.dto.Message;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter {
    private List<Message> messageList;

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        TextView sender_text_message, receiver_text_message;
        CircleImageView user_profile_image;
        RoundedImageView senderImageMsg, receiverImageMsg;

        MessageViewHolder(View view){
            super(view);
            sender_text_message = view.findViewById(R.id.senderMessageText);
            receiver_text_message = view.findViewById(R.id.receiverMessageText);
            user_profile_image = view.findViewById(R.id.messageUserImage);

            senderImageMsg = view.findViewById(R.id.messageImageVsender);
            receiverImageMsg = view.findViewById(R.id.messageImageVreceiver);
        }

    }
}
