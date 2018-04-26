package com.syl.test.rain;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class Rain extends JFrame{
    public Rain(){
        setSize(600,600);
        setVisible(true);
        setBackground(Color.BLACK);
        View rain = new View();
        add(rain);
        new Thread(rain).start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
        new Rain();
    }
}
class View extends JPanel implements Runnable{
    /**
     * 默认雨滴数量
     */
    private int number = 100;
    /**
     * 雨滴容器
     */
    private List<BaseView> list = new ArrayList<>();
    View(){
        setSize(600,600);
        setVisible(true);
        init();
        setBackground(Color.BLACK);
    }
    View(int number){
        this();
        this.number = number;
    }

    /**
     * 初始化雨滴
     */
    private void init() {
        for (int i = 0; i < number; i++) {
            list.add(new RainItem(this.getWidth(),this.getHeight()));
        }
    }

    /**
     * 重写paint方法，调用雨滴的绘制，同时在之前调用g.fillRect，将之前的绘制填充
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(0, 0, getWidth(), getHeight());
        for (BaseView item:list) {
            item.draw(g);
        }
    }

    /**
     * 线程方法
     * 不断改变雨滴的位置，同时调用repaint方法
     * 调用repaint方法的意义就是反复调用patint方法
     */
    @Override
    public void run() {
        while (true){
            for (BaseView item:list) {
                item.move();
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class RainItem implements BaseView{
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