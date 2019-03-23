package com.example.android.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import java.util.List;
import at.blogc.android.views.ExpandableTextView;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder>{
    private List<Review> mReviews;
    private Context mContext;


    public ReviewAdapter(Context context) {
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private TextView author;
        private ExpandableTextView review;
        private TextView textToggle;

        public ViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author_name);
            review = itemView.findViewById(R.id.expandableTextView);
            textToggle = itemView.findViewById(R.id.text_toggle);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Review review = mReviews.get(position);

        TextView authorTextView = holder.author;
        final ExpandableTextView expandableTextView = holder.review;
        final TextView textToggle = holder.textToggle;

        authorTextView.setText(review.getmAouther());
        expandableTextView.setText(review.getmReview());

        // set animation duration via code, but preferable in your layout files by using the animation_duration attribute
        expandableTextView.setAnimationDuration(750L);

        // set interpolators for both expanding and collapsing animations
        expandableTextView.setInterpolator(new OvershootInterpolator());


        textToggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                if (expandableTextView.isExpanded())
                {
                    expandableTextView.collapse();
                    textToggle.setText(R.string.expand);
                }
                else
                {
                    expandableTextView.expand();
                    textToggle.setText(R.string.collapse);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if(null==mReviews){
            return 0;
        }
        return mReviews.size();
    }

    public void setReviewData(List<Review> reviewData) {
        mReviews = reviewData;
        notifyDataSetChanged();
    }
}
