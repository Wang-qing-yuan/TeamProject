package com.zyDeng;

public class Picture implements Comparable<Picture>{
    private String name;
    private String style;
    private long size;

    public Picture() {
    }

    public Picture(String name, String style, long size) {
        this.name = name;
        this.style = style;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public int compareTo(Picture picture) {
        /*long num = picture.getSize();
        if (num == this.size) {
        }*/
        return picture.name.compareTo(this.name);
    }
}
