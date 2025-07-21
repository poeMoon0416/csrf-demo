package com.example.trap_site;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.*;

public class Csrf {
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 4444), 0);

            httpServer.createContext("/", HttpHandlers
                    .of(
                            200,
                            Headers.of(Map.of("Content-Type", List.of("text/html; charset=utf-8"))),
                            Files.readString(Path.of(URI.create(
                                    "file:///D:/ユーザーデータ/OneDrive/デスクトップ/vsc/csrf-demo/trap-site/src/main/resources/csrf.html")))));

            httpServer.createContext("/csrf.css", HttpHandlers
                    .of(
                            200,
                            Headers.of(Map.of("Content-Type", List.of("text/css; charset=utf-8"))),
                            Files.readString(Path.of(URI.create(
                                    "file:///D:/ユーザーデータ/OneDrive/デスクトップ/vsc/csrf-demo/trap-site/src/main/resources/csrf.css")))));

            httpServer.createContext("/csrf.js", HttpHandlers
                    .of(
                            200,
                            Headers.of(Map.of("Content-Type", List.of("text/javascript; charset=utf-8"))),
                            Files.readString(Path.of(URI.create(
                                    "file:///D:/ユーザーデータ/OneDrive/デスクトップ/vsc/csrf-demo/trap-site/src/main/resources/csrf.js")))));

            httpServer.createContext("/cat.jpg", (HttpExchange httpExchange) -> {
                byte[] file = Files.readAllBytes(Path.of(URI.create(
                        "file:/D:/ユーザーデータ/OneDrive/デスクトップ/vsc/csrf-demo/trap-site/src/main/resources/cat.jpg")));
                httpExchange.sendResponseHeaders(200, file.length);
                httpExchange.getResponseHeaders().add("Content-Type", "image/jpeg");
                try (OutputStream out = httpExchange.getResponseBody()) {
                    out.write(file);
                }
            });

            httpServer.start();
            System.out.println(String.format("listen of %s", httpServer.getAddress()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
