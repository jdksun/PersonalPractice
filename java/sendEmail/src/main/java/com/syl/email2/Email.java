package com.syl.email2;

import com.syl.util.EmailInfo;
import com.syl.util.EmailType;
import com.syl.util.PropertiesUtil;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import java.io.File;

public class Email {
    private String host = PropertiesUtil.getProperty("mail.smtp.host");
    private int port = Integer.parseInt(PropertiesUtil.getProperty("mail.smtp.port"));
    private String userName = PropertiesUtil.getProperty("mail.user");
    private String password = PropertiesUtil.getProperty("mail.password");
    private String to = PropertiesUtil.getProperty("mail.receive");



    public void send(EmailInfo info) throws Exception{
        if (info.getType() == EmailType.文本)
            sendText(info);
        else if (info.getType() == EmailType.HTML)
            sendHtml(info);
        else if (info.getType() == EmailType.图片)
            sendImage(info);
        else
            sendAttachment(info);
    }

    private void sendText(EmailInfo info) throws Exception{
        SimpleEmail mail = new SimpleEmail();
        mail.setSmtpPort(port);
        mail.setHostName(host);
        mail.setAuthentication(userName,password);
        mail.setFrom(userName);
        mail.addTo(to);
        mail.setCharset("UTF-8");
        mail.setSubject(info.getTitle());
        mail.setMsg(info.getContent());
        mail.setSentDate(info.getDate());
        mail.send();
    }

    private void sendHtml(EmailInfo info) throws Exception{
        HtmlEmail email = new HtmlEmail();
        email.setSmtpPort(port);
        email.setHostName(host);
        email.setAuthentication(userName,password);
        email.setFrom(userName);
        email.addTo(to);
        email.setCharset("UTF-8");
        email.setSubject(info.getTitle());
        email.setHtmlMsg(info.getContent());
        email.setSentDate(info.getDate());
        email.send();
    }

    private void sendImage(EmailInfo info) throws Exception{
        HtmlEmail email = new HtmlEmail();
        email.setSmtpPort(port);
        email.setHostName(host);
        email.setAuthentication(userName,password);
        email.setFrom(userName);
        email.addTo(to);
        email.setCharset("UTF-8");
        email.setSubject(info.getTitle());
        email.embed(new File(info.getFilePath()),"image");
        email.setHtmlMsg(info.getContent());
        email.setSentDate(info.getDate());
        email.send();
    }

    private void sendAttachment(EmailInfo info) throws Exception{
        MultiPartEmail email = new MultiPartEmail();
        email.setSmtpPort(port);
        email.setHostName(host);
        email.setAuthentication(userName,password);
        email.setFrom(userName);
        email.addTo(to);
        email.setCharset("UTF-8");
        email.setSubject(info.getTitle());
        email.setMsg(info.getContent());
        //创建附件
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(info.getFilePath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName("study.jpg");
        email.attach(attachment);
        email.setSentDate(info.getDate());
        email.send();
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
