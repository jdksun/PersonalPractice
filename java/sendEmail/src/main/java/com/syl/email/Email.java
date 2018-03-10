package com.syl.email;

import com.syl.util.EmailInfo;
import com.syl.util.PropertiesUtil;
import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
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



    public void sendText(EmailInfo infor) throws Exception {
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


    public void sendHtml(EmailInfo info) throws MessagingException {
        Session session = Session.getInstance(props,authenticator);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(props.getProperty("mail.user")));
        message.setRecipient(
                Message.RecipientType.TO,
                new InternetAddress(props.getProperty("mail.receive")));
        message.setSubject(info.getTitle());
        message.setSentDate(info.getDate());
        //设置html的容器
        Multipart mainPart = new MimeMultipart();
        BodyPart html = new MimeBodyPart();
        // 设置HTML内容
        html.setContent(
                info.getContent(),
                info.getType().getMsg());
        mainPart.addBodyPart(html);
        message.setContent(mainPart);
        Transport.send(message);
    }
    public void sendImage (EmailInfo info) throws MessagingException {
        Session session = Session.getInstance(props,authenticator);
        Message mailMessage = new MimeMessage(session);
        mailMessage.setFrom(new InternetAddress(props.getProperty("mail.user")));
        mailMessage.setRecipient(Message.RecipientType.TO,
                new InternetAddress(props.getProperty("mail.receive")));
        mailMessage.setSubject(info.getTitle());
        mailMessage.setSentDate(info.getDate());
        MimeMultipart multipart = new MimeMultipart("related");
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = info.getContent();
        messageBodyPart.setContent(htmlText, info.getType().getMsg());
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart imageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource("F:\\github\\PersonalPractice\\java\\sendEmail\\src\\main\\java\\com\\syl\\email\\study.jpg");
        imageBodyPart.setDataHandler(new DataHandler(fds));
        imageBodyPart.setContentID("image");
        multipart.addBodyPart(imageBodyPart);
        mailMessage.setContent(multipart);
        Transport.send(mailMessage);
    }

    public void sendAttachment(EmailInfo info) throws Exception{
        Session session = Session.getInstance(props,authenticator);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(props.getProperty("mail.user")));
        message.setRecipient(Message.RecipientType.TO,
                new InternetAddress(props.getProperty("mail.receive")));
        message.setSubject(info.getTitle());
        message.setSentDate(info.getDate());
        MimeMultipart mimeMultipart = new MimeMultipart("mixed");
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(info.getContent(),info.getType().getMsg());
        mimeMultipart.addBodyPart(bodyPart);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        File file = new File(info.getFilePath());
        DataSource fds = new FileDataSource(file);
        mimeBodyPart.setDataHandler(new DataHandler(fds));
        mimeMultipart.addBodyPart(mimeBodyPart);
        message.setContent(mimeMultipart);
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
