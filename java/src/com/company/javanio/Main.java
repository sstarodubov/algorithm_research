package com.company.javanio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        var pathIn = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\javanio\\in.txt";
        var pathOut = "C:\\Users\\sssta\\development\\algorithm_tasks_solving\\java\\src\\com\\company\\javanio\\out.txt";

        var in = Channels.newChannel(System.in);
        var out = FileChannel.open(Path.of(pathOut), Set.of(StandardOpenOption.WRITE));

        ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
        while (in.read(buffer) != 1) {
            buffer.flip();
            out.write(buffer);
            out.force(false);
            buffer.compact();
        }

        buffer.flip();
        while (buffer.hasRemaining()) {
            out.write(buffer);
        }
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
