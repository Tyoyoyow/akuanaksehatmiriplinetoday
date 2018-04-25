package com.example.android.akuanaksehatmiriplinetoday;

/**
 * Created by tyo on 24/04/18.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class PenyakitAdapter extends RecyclerView.Adapter<PenyakitAdapter.PenyakitViewHolder> {

//    private GradientDrawable mGradient;
    private ArrayList<Penyakit> mPenyakitData;
    private Context mContext;

    PenyakitAdapter(Context context, ArrayList<Penyakit> penyakitData){
        this.mPenyakitData = penyakitData;
        this.mContext = context;

//        mGradient = new GradientDrawable();
//        mGradient.setColor(Color.GRAY);

//        Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.Batuk);
//        if (drawable!=null){
//            mGradient.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        }
    }


    @Override
    public PenyakitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PenyakitViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }


    @Override
    public void onBindViewHolder(PenyakitAdapter.PenyakitViewHolder holder, int position) {
        Penyakit currentPenyakit = mPenyakitData.get(position);

//        holder.bindTo(currentPenyakit);
        holder.mTitle.setText(currentPenyakit.getNama());

        Glide.with(mContext).load(currentPenyakit.getImage()).into(holder.mPenyakitImage);
    }

    @Override
    public int getItemCount() {
        return mPenyakitData.size();
    }

    class PenyakitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mPenyakitImage;
        private TextView mTitle;
//        private TextView mInfo;
        private Context mContext;
        private Penyakit mCurrentPenyakit;

        private String txtTitle;

        PenyakitViewHolder(Context context, View itemView){
            super(itemView);

            mPenyakitImage = (ImageView) itemView.findViewById(R.id.penyakitImage);
            mTitle = (TextView) itemView.findViewById(R.id.labelTitle);
//            mInfo = (TextView) itemView.findViewById(R.id.infoTitle);

            mContext = context;


            itemView.setOnClickListener(this);

        }

/*        void bindTo(Penyakit currentPenyakit){
            mTitle.setText(currentPenyakit.getNama());


            mCurrentPenyakit = currentPenyakit;
            txtTitle = mTitle.getText().toString();
            Glide.with(mContext).load(currentPenyakit.getImage()).into(mPenyakitImage);
        }*/

        @Override
        public void onClick(View view) {
//            Intent detail = Penyakit.starter(mContext, mCurrentPenyakit.getTitle(), mCurrentPenyakit.getImage());
//            detail.putExtra("title", txtTitle);
//            mContext.startActivity(detail);
        }
    }
}
