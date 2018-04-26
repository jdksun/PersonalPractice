package com.syl.aop.service;

import com.syl.aop.security.CurrentUserHolder;

public class AuthService {
    public void checkAccess(){
        String user = CurrentUserHolder.get();
        if (!"admin".equals(user))
            throw new RuntimeException("operation get allow");
    }
}
