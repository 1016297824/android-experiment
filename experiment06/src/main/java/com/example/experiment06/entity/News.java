package com.example.experiment06.entity;

public class News {
    public int id;
    public String picAdress;
    public String title;
    public String match;

    public News(int id, String title, String match) {
        this.id = id;
        this.title = title;
        this.match = match;
    }
}
