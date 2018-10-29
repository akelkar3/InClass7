package com.mad.homeworkgroup20.inclass7;
/*
* Assignment #: Inclass7
* File Name:Detail Activity
* Students: Ankit Kelkar, SHubhra Mishra
* */

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView title,description, publishedAt;
  String TAG ="test";
  NewsItem data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        //  actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.title_bar_gray)));
        actionBar.setTitle("Detail Activity");
        actionBar.show();

        title= (TextView) findViewById(R.id.title);
        description= (TextView) findViewById(R.id.description);
        ImageView gallary = (ImageView) findViewById(R.id.gallary);
        publishedAt= (TextView) findViewById(R.id.date);

        data = (NewsItem) this.getIntent().getExtras().getSerializable(NewsActivity.KEY_NEWS);
        Log.d(TAG, "onCreate: title" + data.title);
title.setText(data.title);
description.setText(data.description);
publishedAt.setText(data.publishedAt);
        if(data.urlToImage !=null && !data.urlToImage.isEmpty()) {
            Picasso.with(DetailActivity.this).load(data.urlToImage.toString()).placeholder(R.drawable.notfound)
                    .error(R.drawable.notfound).into(gallary);
        }else{
            Picasso.with(DetailActivity.this).load(R.drawable.notfound);
        }
       /* title.setText( this.getIntent().getExtras().getString(MainActivity.newsItem.title));
        description.setText(this.getIntent().getExtras().getString(MainActivity.newsItem.description));
        urlToImage.setText( this.getIntent().getExtras().getString(MainActivity.newsItem.urlToImage));
        publishedAt.setText(this.getIntent().getExtras().getString(MainActivity.newsItem.publishedAt));*/





    }
}
