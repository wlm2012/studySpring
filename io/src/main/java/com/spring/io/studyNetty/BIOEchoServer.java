package com.spring.io.studyNetty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class BIOEchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8001)) {
            System.out.println("server start");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("one client conn: " + socket);
                new Thread(() -> {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                        String msg;
                        while (StringUtils.hasText(msg = reader.readLine())) {
                            System.out.println("msg = " + msg);
                        }
                        System.out.println("finish!");
                        writer.write("finish");
                        writer.flush();
                        writer.close();
                        log.info("finish!");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }
    }
}
