package com.example.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import at.blogc.android.views.ExpandableTextView;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView ;
   private ReviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("hrough a series of daring escapades deep within a dark and dangerous\n" +
                "        criminal underworld, Han Solo meets his mighty future copilot Chewbacca and encounters the\n" +
                "        notorious gambler Lando Calrissian.Through a series of daring escapades deep within a dark\n" +
                "        and dangerous criminal underworld, Han Solo meets his mighty future copilot Chewbacca and\n" +
                "        encounters the notorious gambler Lando Calrissian","Essam"));
        reviews.add(new Review(getString(R.string.long_text),"hblola"));
        reviews.add(new Review(getString(R.string.long_text),"Essam"));
        reviews.add(new Review(getString(R.string.long_text),"Essam"));
        reviews.add(new Review(getString(R.string.long_text),"Essam"));
        reviews.add(new Review(getString(R.string.long_text),"Essam"));
        reviews.add(new Review(getString(R.string.long_text),"Essam"));
        reviews.add(new Review(getString(R.string.long_text),"Essam"));


        recyclerView = findViewById(R.id.reviews_rv);
        adapter = new ReviewAdapter(this);

        recyclerView.setAdapter(adapter);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,0,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.setReviewData(reviews);





    }
}
