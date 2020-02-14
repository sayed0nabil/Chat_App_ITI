package org.example.model;

public class Message {
    private int id;
    private String text ;
    private String format;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getFormat() {
        return format;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Message(){}

    public Message(int id, String text) {
        this.text = text;
    }

    public Message(int id, String text,String format) {
        this.id = id;
    }
}
