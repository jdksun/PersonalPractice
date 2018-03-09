package com.syl.util;

public enum EmailType {

    文本("0","text/html;charset=UTF-8")
    ;
    private String code;
    private String msg;
    EmailType(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
