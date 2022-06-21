package com.company.javanio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 9999);
        InputStream inputStream = clientSocket.getInputStream();
        inputStream.transferTo(System.out);
    }
}
