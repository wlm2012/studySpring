package com.spring.io.studyNetty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOEchoServer {

    public static void main(String[] args) throws IOException {

        try (// 创建一个Selector
             Selector selector = Selector.open();
             // 创建ServerSocketChannel
             ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            // 绑定8002端口
            serverSocketChannel.bind(new InetSocketAddress(8002));
            serverSocketChannel.configureBlocking(false);
            // 将Channel注册到selector上，并注册Accept事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server start");

        }

    }
}
