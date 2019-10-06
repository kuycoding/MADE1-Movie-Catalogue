package com.kuycoding.catalogemoview;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int cover;
    private int poster;
    private String title;
    private String genre;
    private String overview;
    private String runtime;
    private String year;
    private String language;
    private String imdb;
    private String release;
    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Movie() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cover);
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.genre);
        dest.writeString(this.overview);
        dest.writeString(this.runtime);
        dest.writeString(this.year);
        dest.writeString(this.language);
        dest.writeString(this.imdb);
        dest.writeString(this.release);
    }

    protected Movie(Parcel in) {
        this.cover = in.readInt();
        this.poster = in.readInt();
        this.title = in.readString();
        this.genre = in.readString();
        this.overview = in.readString();
        this.runtime = in.readString();
        this.year = in.readString();
        this.language = in.readString();
        this.imdb = in.readString();
        this.release = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
