package com.syl.test.imagetoasc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageProcess {
    public static void main(String[] args) {
        ImageProcess i = new ImageProcess(new char[]{'M','8','V','|',':','.',' '});
        System.out.println(i.ImageChangToString("C:\\Users\\syl\\Desktop\\a.jpg"));;
        i.saveAsTest("C:\\Users\\syl\\Desktop\\a.txt");
    }
    private static char[] dft = {'M','8','V','|',':','.',' '};
    private char[] charset;
    private int default_size = 100;
    private String imageString;
    public ImageProcess(){
        this.charset = dft;
    }
    public ImageProcess(char[] charset){
        this.charset = charset;
    }

    public String ImageChangToString(String path){
        return ImageChangToString(new File(path));
    }

    private String ImageChangToString(File file) {
        if (!file.exists()){
            System.err.println("图片文件不存在，请重启程序，并输入正确的文件路径");
            System.exit(1);
        }
        StringBuffer sb = new StringBuffer();

        try {
            BufferedImage image = ImageIO.read(file);
            image = changeSize(image);
            Color color;
            for (int i = 0;i<image.getHeight();i++){
                for (int j = 0; j < image.getWidth(); j++) {

                    int rgb = image.getRGB(j,i);
                    color = new Color(rgb);
                    int rgbV = (color.getRed() + color.getGreen() + color.getBlue())/3;
                    sb.append(charset[(int)((rgbV*charset.length-1)/255)] + " ");
                }
                sb.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageString = sb.toString();
        return imageString;
    }

    public void saveAsTest(String fileName){
        if (imageString == null||imageString.length() <= 0){
            System.err.println("图片信息尚未读取,请调用ImageToString方法");
            System.exit(0);
        }
        File file = new File(fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (int i = 0; i < imageString.length(); i++) {
                pw.print(imageString.charAt(i));
            }
            pw.close();
            System.out.println(fileName + "-存储文件完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage changeSize(BufferedImage image){
        int height = image.getHeight();
        int width = image.getWidth();
        if (Math.max(height,width)<default_size){
            return image;
        }
        int newHeight;
        int newWidth;

        if (height > width){
            newHeight = default_size;
            newWidth = default_size * width / height;
        }else {
            newWidth = default_size;
            newHeight = default_size * height /width;
        }
        newHeight = 262/5;
        newWidth = 186/5;
        System.out.println(newHeight + " w:"+newWidth);
        BufferedImage sizeImage = new BufferedImage(newWidth,newHeight,image.getType());
        Graphics g = sizeImage.getGraphics();
        g.drawImage(image,0,0,newWidth,newHeight,null);
        g.dispose();
        return sizeImage;
    }

    public static void treeImage(String srcFile,String targetFile){
        File src = new File(srcFile);
        File target = new File(targetFile);
        if (!src.exists()){
            src.mkdirs();
        }
        if (!target.exists()){
            target.mkdirs();
        }
        if (!src.isDirectory() || !target.isDirectory()){
            System.err.println("源路径或目标路径错误，请检查后重新运行程序");
            System.exit(0);
        }
        treeImage(src,target);
    }

    private static void treeImage(File src,File target){
        ImageProcess ip = new ImageProcess();
        File[] list = src.listFiles();
        for (File item:list) {
            if (!item.isFile()) continue;
            ip.ImageChangToString(item);
            ip.saveAsTest(target+"/"+item.getName()+".txt");
            System.out.println(target.getName()+"转换完成");
        }
        System.out.println("所有文件转换完成");
    }
}
