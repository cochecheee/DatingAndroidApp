package com.example.datingappandroid.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datingappandroid.R;
import com.example.datingappandroid.databinding.CardViewProfileBinding;
import com.example.datingappandroid.models.Swipping;

import java.util.List;


public class SwippingAdapter extends RecyclerView.Adapter<SwippingAdapter.SwippingViewHolder>{
    // TODO 1: define a ViewHolder
    public static class SwippingViewHolder extends RecyclerView.ViewHolder {
        final CardViewProfileBinding binding;

        public SwippingViewHolder(CardViewProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    // TODO 2: fetch data
    private List<Swipping> swippings;
    public List<Swipping> getSwippings() {
        return swippings;
    }

    public SwippingAdapter(List<Swipping> swippings) {
        this.swippings = swippings;
    }
    // TODO 3:...
    @NonNull
    @Override
    public SwippingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardViewProfileBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.card_view_profile,
                parent,
                false
        );
        return new SwippingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SwippingViewHolder holder, int position) {
        if (swippings != null) {
            holder.binding.setSwipper(swippings.get(position));
            holder.binding.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return swippings != null ? swippings.size() : 0;
    }
}
