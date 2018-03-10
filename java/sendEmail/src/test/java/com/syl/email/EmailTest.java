package com.syl.email;

import com.syl.util.EmailInfo;
import com.syl.util.EmailType;
import org.junit.Test;

public class EmailTest {
    @Test
    public void sendText() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题","测试内容", EmailType.文本);
        email.sendText(info);
    }
    @Test
    public void sendHtml() throws Exception {
        Email email = new Email();
        EmailInfo info2 = new EmailInfo("测试标题","<html><body><img src='http://avatar.csdn.net/A/C/A/1_jianggujin.jpg'/><div>this is a HTML email.</div></body></html>", EmailType.文本);
        email.sendHtml(info2);
    }
    @Test
    public void sendImage() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题",
                "<html><body><img src='cid:image'/>" +
                        "<div>this is a HTML email.</div></body></html>",
                EmailType.文本);
        email.sendImage(info);
    }
    @Test
    public void endAttachment() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题",
                "<html><body><img src='cid:image'/>" +
                        "<div>this is a HTML email.</div></body></html>",
                EmailType.文本,
                "F:\\github\\PersonalPractice\\java\\sendEmail\\src\\main\\java\\com\\syl\\email\\study.jpg");
        email.sendAttachment(info);
    }

}