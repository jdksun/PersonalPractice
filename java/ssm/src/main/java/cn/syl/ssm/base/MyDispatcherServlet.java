package cn.syl.ssm.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyDispatcherServlet extends HttpServlet {

    private Map<String,Object> ioc = new HashMap<>();

    private Properties properties;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        //加载配置
        loadConfig();

        //加载扫描包
        loadScanner();

        //加载Ioc容器，将bean托管给容器（其实就是Map）
        loadIoc();

        //加载依赖
        loadAutowired();

        //加载处理器映射
        loadHandlerMapping();
    }

    private void loadAutowired() {
    }

    private void loadHandlerMapping() {
    }

    private void loadIoc() {
    }

    private void loadScanner() {
    }

    private void loadConfig() {
        InputStream inputStream = null;

        inputStream = this.getClass().getResourceAsStream("path");

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
