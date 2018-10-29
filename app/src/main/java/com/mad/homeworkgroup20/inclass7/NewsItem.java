package com.mad.homeworkgroup20.inclass7;

import java.io.Serializable;

/**
 * Created by Aliandro on 2/19/2018.
 */

public class NewsItem implements Serializable {
String title,description,urlToImage, publishedAt;

    public NewsItem(String title, String description, String urlToImage, String publishedAt) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
