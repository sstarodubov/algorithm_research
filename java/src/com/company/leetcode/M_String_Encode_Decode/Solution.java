package com.company.leetcode.M_String_Encode_Decode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    static String del = "&%#";
    static String empty = "empty%s".formatted(del);

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return empty;
        }
        return strs.stream().collect(Collectors.joining(del));
    }

    public List<String> decode(String str) {
        if (str.equals(empty)) return List.of();
        if (str.isEmpty()) return List.of("");
        return Arrays.asList(str.split(del));
    }
}

