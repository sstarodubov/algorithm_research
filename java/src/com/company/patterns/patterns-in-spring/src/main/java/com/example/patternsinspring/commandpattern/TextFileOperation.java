package com.example.patternsinspring.commandpattern;

@FunctionalInterface
public interface TextFileOperation {
    String execute(TextFile textFile);
}
