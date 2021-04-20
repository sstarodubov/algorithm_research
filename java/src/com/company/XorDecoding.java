package com.company;

import java.util.Arrays;

public class XorDecoding {
    public static void main(String[] args) {
        var b = new XorDecoding();
        assert Arrays.equals(new int[]{1, 0, 2, 1}, b.decode(new int[]{1, 2, 3}, 1)) : "1" ;
        assert Arrays.equals(new int[]{4, 2, 0, 7, 4}, b.decode(new int[]{6, 2, 7, 3}, 4)) : "4";
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int[] decode(int[] encoded, int first) {
        int[] out = new int[encoded.length + 1];
        out[0] = first;
        int po = 1;
        while (po < out.length) {
            out[po] = out[po - 1] ^ encoded[po - 1];
            po++;
        }
        return out;
    }
}
