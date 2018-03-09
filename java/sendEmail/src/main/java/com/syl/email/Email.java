package com.syl.email;

import com.syl.util.PropertiesUtil;
import org.apache.log4j.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class Email {
    private static Logger logger = Logger.getLogger(Email.class);
    //基本信息
    private static Properties props;
    //邮箱授权
    private Authenticator authenticator;
    static {
        props = new Properties();
        props.put("mail.smtp.auth",PropertiesUtil.getProperty("mail.smtp.auth"));
        props.put("mail.smtp.port",PropertiesUtil.getProperty("mail.smtp.port"));
        props.put("mail.smtp.host",PropertiesUtil.getProperty("mail.smtp.host"));
        props.put("mail.user",PropertiesUtil.getProperty("mail.user"));
        props.put("mail.password",PropertiesUtil.getProperty("mail.password"));
        props.put("mail.receive",PropertiesUtil.getProperty("mail.receive"));
    }
    public Email(){
        //初始化邮件授权
        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(username,password);
            }
        };
    }



    public void sendOne(EmailInfo infor) throws Exception {
        //邮件会话
       Session session = Session.getInstance(props,authenticator);
        //邮件消息
       MimeMessage message = new MimeMessage(session);
        //设置发件人
       InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
       message.setFrom(form);
        //设置收件人
       InternetAddress to = new InternetAddress(props.getProperty("mail.receive"));
       message.setRecipient(Message.RecipientType.TO,to);
       //邮件标题
       message.setSubject(infor.getTitle());
       //邮件发送时间
        message.setSentDate(infor.getDate());
       //邮件内容
       message.setContent(infor.getContent(), infor.getType().getMsg());
       //发送邮件
       Transport.send(message);
    }


    public void changeReceive(String receive){
        props.put("mail.receive",receive);
    }

    public void changeSend(String send,String password){
        props.put("mail.user",send);
        props.put("mail.password",password);
        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(username,password);
            }
        };
    }

}
