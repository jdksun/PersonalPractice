package com.syl.webServer;

import org.junit.Test;

import static org.junit.Assert.*;

public class HttpServerTest {
    @Test
    public void server() throws Exception {

        HttpServer server = new HttpServer();
        server.server();
    }

    @Test
    public void client() throws Exception {

        HttpServer server = new HttpServer();
        server.client();
    }
}