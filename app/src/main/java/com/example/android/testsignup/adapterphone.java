package com.example.flareon;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flareon.R;

import java.util.ArrayList;

    public class adapterphone extends RecyclerView.Adapter<adapterphone.PhoneViewHold>  {

        ArrayList<carouselhelper> phoneLaocations;
        final private ListItemClickListener mOnClickListener;

        public adapterphone(ArrayList<carouselhelper> phoneLaocations, ListItemClickListener listener) {
            this.phoneLaocations = phoneLaocations;
            mOnClickListener = listener;
        }

        @NonNull

        @Override
        public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phonerecyclercard, parent, false);
            return new PhoneViewHold(view);

        }

        @Override
        public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


            carouselhelper phonehelper = phoneLaocations.get(position);
            holder.image.setImageResource(phonehelper.getImage());
            holder.relativeLayout.setBackground(phonehelper.getgradient());
        }

        @Override
        public int getItemCount() {
            return phoneLaocations.size();

        }

        public interface ListItemClickListener {
            void onphoneListClick(int clickedItemIndex);
        }

        public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


            ImageView image;
            TextView title;
            RelativeLayout relativeLayout;


            public PhoneViewHold(@NonNull View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                //hooks

                image = itemView.findViewById(R.id.phone_image);

                relativeLayout = itemView.findViewById(R.id.background_color);

            }

            @Override
            public void onClick(View v) {
                int clickedPosition = getAdapterPosition();
                mOnClickListener.onphoneListClick(clickedPosition);
            }
        }

    }