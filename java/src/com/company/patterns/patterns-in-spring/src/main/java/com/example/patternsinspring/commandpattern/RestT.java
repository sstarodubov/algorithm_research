package com.example.patternsinspring.commandpattern;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestT {

    private final TextFileOperationExecutor executor;

    private final SaveTextFileOperation saveCommand;
    private final OpenTextFileOperation openCommand;


    @GetMapping("/command-pattern")
    public String invoke() {

        TextFile textFile = new TextFile("some.file");

        System.out.println(executor.executeOperationOnFile(saveCommand, textFile));
        System.out.println(executor.executeOperationOnFile(openCommand, textFile));
        System.out.println(executor.executeOperationOnFile(file -> file.name + " is deleted", textFile));
        return "ok";
    }
}
