package com.example.patternsinspring.commandpattern;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TextFileOperationExecutor {

    private final List<TextFileOperation> operations = new ArrayList<>();

    public String executeOperationOnFile(TextFileOperation operation, TextFile textFile) {
        operations.add(operation);
        return operation.execute(textFile);
    }
}
