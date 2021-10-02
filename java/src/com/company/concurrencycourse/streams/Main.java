package com.company.concurrencycourse.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        final String path = "/home/haxul/Development/workspaces/java/algorithm_tasks_solving/java/src/com/company/concurrencycourse/streams/text.txt";
        Files.lines(Path.of(path)).forEach(System.out::println);
    }
}
