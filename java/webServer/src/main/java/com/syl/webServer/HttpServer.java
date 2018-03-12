package com.syl.webServer;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {


    public void server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(80);
        Socket socket =serverSocket.accept();
        InputStream is = socket.getInputStream();
        int r = -1;
        while((r = is.read()) != -1){
            System.out.print((char)r);
        }
    }

    public void client() throws Exception
    {
        Socket socket = new Socket("127.0.0.1", 80);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream()));
        writer.write("GET /Servlet/test.html HTTP/1.1\r\n");
        writer.write("Host: 127.0.0.1\r\n");
        writer.write("Connection: keep-alive\r\n");
        writer.write("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n");
        writer.write("User-Agent: Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36\r\n");
        writer.write("Accept-Encoding: gzip,deflate,sdch\r\n");
        writer.write("Accept-Language: zh-CN,zh;q=0.8\r\n");
        writer.write("\r\n");
        writer.flush();
        InputStream stream = socket.getInputStream();
        int r = -1;
        while ((r = stream.read()) != -1)
        {
            System.out.print((char) r);
        }
    }
}
