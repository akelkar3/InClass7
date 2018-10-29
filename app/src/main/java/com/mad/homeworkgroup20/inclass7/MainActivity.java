package com.mad.homeworkgroup20.inclass7;
/*
* Assignment #: Inclass7
* File Name:Main Activity
* Students: Ankit Kelkar, SHubhra Mishra
* */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String TAG ="test";
static  String KEY_CAT="category";
    final    String[] cat= {"business","entertainment", "general", "health", "science", "sports","technology"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                        android.R.id.text1, cat);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Clicked item " + position + ", category " + cat[position]);
              //  Toast.makeText(MainActivity.this, "Clicked item " + position + ", color " + cat[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                intent.putExtra(KEY_CAT,cat[position]);
                startActivity(intent);
            }
        });

    }
}
