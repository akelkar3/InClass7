package com.mad.homeworkgroup20.inclass7;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Aliandro on 2/26/2018.
 */

public class NewsAdapter extends ArrayAdapter<NewsItem> {
    public NewsAdapter(Context context, int resource, ArrayList<NewsItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsItem news = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.newsitem, parent, false);

        TextView title = (TextView)convertView.findViewById(R.id.listTitle);
        TextView date = (TextView)convertView.findViewById(R.id.listPublishAt);
        ImageView image = (ImageView)convertView.findViewById(R.id.newsImage);
       title.setText(news.title);
       date.setText(news.publishedAt);

        if(news.urlToImage !=null && !news.urlToImage.isEmpty()) {
            Picasso.with(convertView.getContext()).load(news.urlToImage.toString()).placeholder(R.drawable.notfound)
                    .error(R.drawable.notfound).into(image);
        }else{
            Picasso.with(convertView.getContext()).load(R.drawable.notfound);
        }
        //set the data from the news object

        return convertView;
    }
}
