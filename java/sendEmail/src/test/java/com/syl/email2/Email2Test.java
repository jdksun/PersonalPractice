package com.syl.email2;

import com.syl.util.EmailInfo;
import com.syl.util.EmailType;
import org.junit.Test;

public class Email2Test {
    @Test
    public void sendText() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题","测试内容", EmailType.文本);
        email.send(info);
    }

    @Test
    public void sendHtml() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题",
                "<html><body><img src='http://avatar.csdn.net/A/C/A/1_jianggujin.jpg'/><div>this is a HTML email.</div></body></html>",
                EmailType.HTML
        );
        email.send(info);
    }

    @Test
    public void sendImage() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题",
                "<html><body><img src='cid:image'/><div>this is a HTML email.</div></body></html>",
                EmailType.图片,
                "F:\\github\\PersonalPractice\\java\\sendEmail\\src\\main\\java\\com\\syl\\email\\study.jpg");
        email.send(info);
    }

    @Test
    public void sendAttachment() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题",
                "this is a Attachment email.this email has a attachment!",
                EmailType.内嵌文件,
                "F:\\github\\PersonalPractice\\java\\sendEmail\\src\\main\\java\\com\\syl\\email\\study.jpg");
        email.send(info);
    }

}