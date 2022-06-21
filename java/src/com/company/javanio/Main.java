package com.company.javanio;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        var pathIn = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\javanio\\in.txt";
        var pathOut = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\javanio\\out.txt";

        var sock = ServerSocketChannel.open();
        sock.socket().bind(new InetSocketAddress(9999));
        sock.configureBlocking(true);
        var buf = ByteBuffer.wrap("hello from server".getBytes(StandardCharsets.UTF_8));
        System.out.println(sock.socket().getLocalSocketAddress());
        while (true) {
            SocketChannel channel = sock.accept();
            if (channel == null) {
                System.out.println("channel is null");
                return;
            }
            buf.rewind();

            channel.write(buf);
            channel.close();
        }
    }

    static void mapFile() throws IOException {
        var pathIn = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\javanio\\in.txt";
        var pathOut = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\javanio\\out.txt";
        var buffer = CharBuffer.wrap("fuck you");
        var channel = FileChannel.open(Path.of(pathOut), Set.of(StandardOpenOption.WRITE, StandardOpenOption.READ));
        var mappedFileBuf = channel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length());
        mappedFileBuf.put(StandardCharsets.UTF_8.encode(buffer));

        System.out.println(Files.readAllLines(Path.of(pathOut)));
    }

    static void copy(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        while (src.read(buffer) != -1) {
            buffer.flip();
            dest.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()) dest.write(buffer);
    }

    static void copyAlt(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        while (src.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) dest.write(buffer);
            buffer.clear();
        }
    }
}
