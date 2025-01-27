package com.example.datingappandroid.adapters;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datingappandroid.R;
import com.example.datingappandroid.models.dto.Message;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
    // todo 1: initialize viewholder
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

    // todo 2: initilize list data
    List<Message> messages;
    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    // todo 3: define item layout
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_message_layout, parent, false);
        MessageViewHolder viewHolder = new MessageViewHolder(view);
        return viewHolder;
    }

    // todo 4: render data to view
    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        // get sender user id, example sender user1, receiver user2
        String from_user_ID = "user1";

        holder.receiver_text_message.setVisibility(View.INVISIBLE);
        holder.user_profile_image.setVisibility(View.INVISIBLE);

        holder.senderImageMsg.setVisibility(View.GONE);
        holder.receiverImageMsg.setVisibility(View.GONE);

        if (from_user_ID.equals(message.getFrom())){
            holder.sender_text_message.setBackgroundResource(R.drawable.single_message_text_another_background);
            holder.sender_text_message.setTextColor(Color.BLACK);
            holder.sender_text_message.setGravity(Gravity.LEFT);
            holder.sender_text_message.setText(message.getMessage());
        } else {
            holder.sender_text_message.setVisibility(View.INVISIBLE);
            holder.receiver_text_message.setVisibility(View.VISIBLE);
            holder.user_profile_image.setVisibility(View.VISIBLE);

            holder.receiver_text_message.setBackgroundResource(R.drawable.single_message_text_background);
            holder.receiver_text_message.setTextColor(Color.WHITE);
            holder.receiver_text_message.setGravity(Gravity.LEFT);
            holder.receiver_text_message.setText(message.getMessage());
        }

    }

    // get size of item
    @Override
    public int getItemCount() {
        return messages.size();
    }
}
