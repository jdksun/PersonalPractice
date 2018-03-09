package com.syl.email;

import com.syl.util.EmailType;

import java.util.Date;

public class EmailInfo {

    private String title;
    private String content;
    private Date date;
    private EmailType type;

    public EmailInfo(){}

    public EmailInfo(String title, String content, EmailType type) {
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        this.type = type;
    }
}
