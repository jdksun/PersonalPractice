package com.syl.test.proxy;

import java.awt.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        BaseView[] elements = new BaseView[1000];
        for (int i = 0; i < elements.length; i++) {
            final RainItem value = new RainItem(100,100);
            Object obj = Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),value.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.printf("名称%s，参数%s\n",method.getName(), Arrays.toString(args));
                    return method.invoke(value,args);
                }
            });
            elements[i] = (BaseView) obj;
        }


    }
}
class RainItem implements BaseView {
    private int height;//背景高
    private int width;//背景宽
    private int startX;//开始位置ｘ轴
    private int startY;//开始位置ｙ轴
    private int endX;//结束位置ｘ轴
    private int endY;//结束位置ｙ轴
    private int sizeX;//雨滴大小
    private int sizeY;//雨滴大小
    private float of;//移动倍率
    private Random random;//随机数
    private Color color;//雨滴颜色


    public RainItem(int height, int width) {
        this.height = height;
        this.width = width;
        init();
    }
    public void setWidthAndHeight(int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public void init(){
        random = new Random();
        sizeX = 1 + random.nextInt(10);
        sizeY = 10 + random.nextInt(20);
        startX = random.nextInt(width);
        startY = random.nextInt(height);
        endX = startX + sizeX;
        endY = startY + sizeY;
        of = (float)(0.2+random.nextFloat());
        color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(startX,startY,endX,endY);
    }
    @Override
    public void move(){
        startX += sizeX*of;
        startY += sizeY*of;
        endX += sizeX*of;
        endY += sizeY*of;
        if (startX > width || startY > height){
            init();
        }
    }
}
interface BaseView {
    void draw(Graphics g);

    void move();

    void init();
}