package com.example.patternsinspring.commandpattern;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SaveTextFileOperation implements TextFileOperation {

    @Override
    public String execute(TextFile textFile) {
        return textFile.save();
    }

}
