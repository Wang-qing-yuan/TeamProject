package com.zyDeng;

import java.util.Set;

public class Posts {
    private String title;
    private String author;
    private String time;
    private String content;
    private Set<Picture> picture;


    public Posts() {
    }

    public Posts(String title, String author, String time, String content, Set<Picture> picture) {
        this.title = title;
        this.author = author;
        this.time = time;
        this.content = content;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Picture> getPicture() {
        return picture;
    }

    public void setPicture(Set<Picture> picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", picture=" + picture +
                '}';
    }
}
