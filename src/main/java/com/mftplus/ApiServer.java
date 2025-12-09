package com.mftplus;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

public class ApiServer {
    public static void main(String[] args) throws IOException {
        ResourceConfig config = new PackagesResourceConfig("com.mftplus.controller.rest");
        HttpServer server = HttpServerFactory.create("http://localhost:8085/rest/", config);
        server.start();
    }
}
