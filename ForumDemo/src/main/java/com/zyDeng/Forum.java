package com.zyDeng;

import java.util.List;

public class Forum {
    private Integer size;
    private List authorList;
    private List postsList;

    public Forum() {
    }

    public Forum(Integer size, List authorList, List postsList) {
        this.size = size;
        this.authorList = authorList;
        this.postsList = postsList;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List authorList) {
        this.authorList = authorList;
    }

    public List getPostsList() {
        return postsList;
    }

    public void setPostsList(List postsList) {
        this.postsList = postsList;
    }
}
