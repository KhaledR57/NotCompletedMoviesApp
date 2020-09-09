package com.example.moviesapp;

public class PagerSlide {
    private int image;
    private String title;
    private String body;

    public PagerSlide(int image, String title, String body) {
        this.image = image;
        this.title = title;
        this.body = body;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
