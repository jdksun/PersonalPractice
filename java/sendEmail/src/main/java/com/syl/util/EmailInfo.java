package com.syl.util;

import com.syl.util.EmailType;

import java.util.Date;

public class EmailInfo {
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 邮件日期，默认为new Date()
     */
    private Date date;
    /**
     * 邮件类型
     */
    private EmailType type;
    /**
     * 带有的文件的路径
     */
    private String filePath;

    public EmailInfo(String title, String content, EmailType type, String filePath) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.date = new Date();
        this.filePath = filePath;
    }

    public EmailInfo(){}

    public EmailInfo(String title, String content, EmailType type) {
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.type = type;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
