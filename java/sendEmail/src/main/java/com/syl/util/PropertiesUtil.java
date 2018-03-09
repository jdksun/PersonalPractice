package com.syl.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
    private static Logger logger = Logger.getLogger(PropertiesUtil.class);
    private static Properties properties;
    public static String filename = "email.properties";
    static {
        properties = new Properties();
        try {
            properties.load(
                    new InputStreamReader
                            (PropertiesUtil.class.getClassLoader().
                                    getResourceAsStream(filename)));
        } catch (IOException e) {
            logger.error("【配置文件加载错误】,错误信息:{}",e);
        }
    }

    public static String getProperty(String key){
        String value = properties.getProperty(key);
        if (value == null) return null;
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){
        String value = properties.getProperty(key,defaultValue);
        if (value == null) return null;
        return value.trim();
    }
}
