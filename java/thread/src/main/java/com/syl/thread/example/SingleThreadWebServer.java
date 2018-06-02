package com.syl.thread.example;

import jdk.internal.util.xml.impl.Input;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SingleThreadWebServer
 * <p/>
 * Sequential web server
 *
 * @author Brian Goetz and Tim Peierls
 */

public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
        try {
            InputStream is = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            while ((len = is.read(bytes,0,len))!= -1){
                os.write(bytes,0,len);
            }
            System.out.println(new String(os.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
