package com.example.flareon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements adapterphone.ListItemClickListener {

    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        //Hooks
        phoneRecycler = findViewById(R.id.my_recyclers);
        phoneRecycler();

    }

    private void phoneRecycler() {

        //All Gradients
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<carouselhelper> phonelocations = new ArrayList<>();
        phonelocations.add(new carouselhelper(gradient1, R.drawable.movie2, "Samsung"));
        phonelocations.add(new carouselhelper(gradient4, R.drawable.batman, "Vivo"));
        phonelocations.add(new carouselhelper(gradient2, R.drawable.bat, "Apple"));
        phonelocations.add(new carouselhelper(gradient4, R.drawable.goog, "Realme"));

        phonelocations.add(new carouselhelper(gradient2, R.drawable.goog, "Poco"));


        adapter = new adapterphone(phonelocations,this);
        phoneRecycler.setAdapter(adapter);

    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }

  /*  @Override
    public void onphoneListClick(int clickedItemIndex) {

        Intent mIntent;
        switch (clickedItemIndex){
            case 0: //first item in Recycler view
                mIntent  = new Intent(MainActivity.this, samsung.class);
                startActivity(mIntent);
                break;
            case 1: //second item in Recycler view
                mIntent = new Intent(MainActivity.this, vivo.class);
                startActivity(mIntent);
                break;
            case 2: //third item in Recycler view
                mIntent = new Intent(MainActivity.this, apple.class);
                startActivity(mIntent);
                break;
            case 3: //third item in Recycler view
                mIntent = new Intent(MainActivity.this, realme.class);
                startActivity(mIntent);
                break;
            case 4: //third item in Recycler view
                mIntent = new Intent(MainActivity.this, poco.class);
                startActivity(mIntent);
                break;

        }


    }*/
}