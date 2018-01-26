package com.example.android.androidtutorial2;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Test> tests;
    Test test;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, topic, makerName, date, description, testNumberText;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.nameText);
            topic = view.findViewById(R.id.topicText);
            makerName = view.findViewById(R.id.makerNameText);
            date = view.findViewById(R.id.dateText);
            description = view.findViewById(R.id.descriptionText);
            testNumberText = view.findViewById(R.id.testNumberText);
        }
    }

    public RecyclerViewAdapter(ArrayList<Test> tests) {
        this.tests = tests;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_menu_item, parent, false);
        final Button start2;
        final ImageButton showDescription, hideDiscription, addToList, start;
        start = (ImageButton) itemView.findViewById(R.id.startButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTest();
            }
        });
        start2 = (Button) itemView.findViewById(R.id.startButton2);
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTest();
            }
        });
        addToList = (ImageButton) itemView.findViewById(R.id.addToListButton);
        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isAuthenticated == true) {
                    MainActivity.user.addTest(test);
                    Toast.makeText(parent.getContext(), "Added to your list", Toast.LENGTH_LONG).show();
                } else if (MainActivity.isAuthenticated == false) {
                    Toast.makeText(parent.getContext(), "Please Log in First", Toast.LENGTH_LONG).show();
                }
            }
        });
        showDescription = (ImageButton) itemView.findViewById(R.id.descriptionButton);
        showDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardView cardview = itemView.findViewById(R.id.card_view);
                LinearLayout layout = itemView.findViewById(R.id.descriptionLayout);
                int height = cardview.getHeight();
                if (showDescription.getContentDescription().equals("12")) {
                    layout.setVisibility(View.VISIBLE);
                    showDescription.setImageDrawable(parent.getResources().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
                    cardview.getLayoutParams().height = CardView.LayoutParams.WRAP_CONTENT;
                    showDescription.setContentDescription("24");
                } else if (showDescription.getContentDescription().equals("24")) {
                    showDescription.setContentDescription("12");
                    layout.setVisibility(View.INVISIBLE);
                    showDescription.setImageDrawable(parent.getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
                    cardview.getLayoutParams().height = 225;
                }
            }
        });

        hideDiscription = (ImageButton) itemView.findViewById(R.id.hideDescriptionButton);
        hideDiscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = itemView.findViewById(R.id.descriptionLayout);
                layout.setVisibility(View.INVISIBLE);
                CardView cardview = itemView.findViewById(R.id.card_view);
                cardview.getLayoutParams().height = 150;
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        test = tests.get(position);
        holder.name.setText(test.getName());
        holder.topic.setText("Topic : " + test.getTopic());
        holder.makerName.setText("Made by : " + test.getMakerName());
        holder.date.setText("" + test.getDate().getYear() + " / " + test.getDate().getMonth() + " / " + test.getDate().getDay());
        holder.description.setText(test.getDiscription());
        holder.testNumberText.setText("" + (position + 1));
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public void startTest() {

    }


}