package com.syl.email;

import com.syl.util.EmailType;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    @Test
    public void se() throws Exception {
        Email email = new Email();
        EmailInfo info = new EmailInfo("测试标题","测试内容", EmailType.文本);
        email.sendOne(info);
    }

}