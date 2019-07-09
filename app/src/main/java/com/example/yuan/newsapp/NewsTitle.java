package com.example.yuan.newsapp;

public class NewsTitle {

    String title;
    String date;
    String category;
    String author_name;
    String url;

    public NewsTitle(String title, String date, String category, String author_name, String url) {
        this.title = title;
        this.date = date;
        this.category = category;
        this.author_name = author_name;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getUrl() {
        return url;
    }
}
