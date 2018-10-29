package com.mad.homeworkgroup20.inclass7;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity  implements getData.IData{
String data,TAG="test";
static  String KEY_NEWS="newsItem";
    String apiKey="f3e97abda19c49eabbfe788bba799421";
    ArrayList<NewsItem> newsItems =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        data=  this.getIntent().getStringExtra(MainActivity.KEY_CAT);
        Log.d(TAG, "onCreate: Category: "+ data);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
      //  actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.title_bar_gray)));
        actionBar.setTitle(data);
        actionBar.show();



        if (isConnected()) {
            String url="https://newsapi.org/v2/top-headlines";
            RequestParams params=new RequestParams();
            params.addParameter("country","us");
            params.addParameter("category",data);
            params.addParameter("apiKey",apiKey);

            new getData(NewsActivity.this,NewsActivity.this).execute( params.getEncodedUrl(url));

        } else {
            Toast.makeText(NewsActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }


    }
    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
                        && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
            return false;
        }
        return true;
    }

    @Override
    public void handleData(ArrayList<NewsItem> data) {

        newsItems = new ArrayList<>();
        newsItems.addAll(data);
        if (data == null || data.size()==0) {
            Toast.makeText(this, "No News Found", Toast.LENGTH_SHORT).show();
        }else{
           // showData(data.get(current));
            ListView listView = (ListView)findViewById(R.id.newsListView);
            NewsAdapter adapter = new NewsAdapter(this, R.layout.newsitem, newsItems);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    NewsItem tempnews = newsItems.get(position);
                    Log.d(TAG, "Clicked item " + position + ", color " +tempnews.toString());
                  //  Toast.makeText(NewsActivity.this, "clicked "+ newsItems.get(position).title, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NewsActivity.this, DetailActivity.class);
                    intent.putExtra(KEY_NEWS,tempnews);
                    startActivity(intent);
                }
            });

            Log.d(TAG, "handleData: got news count = "+newsItems.size());
        }



    }
}
