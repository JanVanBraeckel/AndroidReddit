package com.example.gebruiker.redditclient.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gebruiker.redditclient.R;
import com.example.gebruiker.redditclient.model.Post;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Jan on 22/12/2015.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

    private Context mContext;
    private List<Post> mPosts;

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImage;
        private final TextView mTitle;

        public MainViewHolder(View itemView) {
            super(itemView);
            mImage = ButterKnife.findById(itemView, R.id.postImage);
            mTitle = ButterKnife.findById(itemView, R.id.postTitle);
        }
    }

    public MainAdapter(List<Post> posts, Context context) {
        mPosts = posts;
        mContext = context;
    }

    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MainAdapter.MainViewHolder holder, int position) {
        final Post post = mPosts.get(position);

        holder.mTitle.setText(post.getTitle());
        Glide.with(mContext)
                .load(post.getThumbnail())
                .placeholder(R.drawable.reddit)
                .fitCenter()
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void addItems(List<Post> posts){
        mPosts.addAll(posts);
        notifyDataSetChanged();
    }
}