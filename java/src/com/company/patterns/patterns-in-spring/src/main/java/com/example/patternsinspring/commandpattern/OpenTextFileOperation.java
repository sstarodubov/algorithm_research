package com.example.patternsinspring.commandpattern;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OpenTextFileOperation implements TextFileOperation {


    @Override
    public String execute(TextFile textFile) {
        return textFile.open();
    }
}
