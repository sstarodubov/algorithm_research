package com.example.patternsinspring.commandpattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TextFile {

    public String name;

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }
}
