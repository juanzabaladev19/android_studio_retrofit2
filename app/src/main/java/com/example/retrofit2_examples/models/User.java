package com.example.retrofit2_examples.models;

public class User {
    private Data data;
    private Support support;

    public Data getData() { return data; }
    public void setData(Data value) { this.data = value; }

    public Support getSupport() { return support; }
    public void setSupport(Support value) { this.support = value; }
}



class Support {
    private String url;
    private String text;

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }
}