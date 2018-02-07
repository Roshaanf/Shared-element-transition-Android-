package com.example.roshaan.sharedelementtransition.adapter;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.sharedelementtransition.Callback;
import com.example.roshaan.sharedelementtransition.Model;
import com.example.roshaan.sharedelementtransition.R;
import com.example.roshaan.sharedelementtransition.databinding.RecyclerItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshaan on 2/6/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    RecyclerItemBinding binding;
    List<Model> list;
    Callback callback;

    public Adapter(List<Model> list, Callback callback) {
        this.list = list;
        this.callback=callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setItem(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerItemBinding binding;

        public ViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setItem(final Model model, final int postion) {

            final String textTransitionName="transitionText" + postion;
            final String imageTransitionName="transition" + postion;

            binding.imageView.setImageResource(model.getAvatar());
            binding.textView.setText(model.getName());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                binding.textView.setTransitionName(textTransitionName);
                binding.imageView.setTransitionName(imageTransitionName);
            }

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    List<Object> objects=new ArrayList<>();
                    objects.add(binding.imageView);
                    objects.add(binding.textView);
                    objects.add(model.getAvatar());
                    objects.add(model.getName());

                    callback.revoke(objects);

                }
            });

        }
    }
}
