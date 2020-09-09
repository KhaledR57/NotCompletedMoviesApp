package com.example.moviesapp;

public class Movies {
    private String title;
    private String year;
    private String released;
    private String runTime;
    private String genre;
    private String director;
    private String plot;
    private int poster;

    public Movies(String title, String year, String released, String runTime, String genre, String director, String plot, int poster) {
        this.title = title;
        this.year = year;
        this.released = released;
        this.runTime = runTime;
        this.genre = genre;
        this.director = director;
        this.plot = plot;
        this.poster = poster;
    }

    public Movies(String title, String year, int poster) {
        this.title = title;
        this.year = year;
        this.poster = poster;
    }

    public Movies(String year, int poster, String runTime,String title) {
        this.year = year;
        this.runTime = runTime;
        this.poster = poster;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
