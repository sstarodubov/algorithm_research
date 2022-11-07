package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyIndexCounting {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(KeyIndexCounting.sort(new int[]{1, 6, 0, 3, 3, 4, 2}, 0, 6)));
    }

    private final int R = 31;
    private final String arr;
    private final int[] count;

    private final Map<Character, Integer> alpha = constructMap();

    public KeyIndexCounting(final String s) {
        this.arr = s;
        count = new int[R + 1];
    }

    public static int[] sort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        return output;
    }

    public String sort() {
        for (int i = 0; i < arr.length(); i++) {
            count[alpha.get(arr.charAt(i)) + 1]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        char[] t = new char[arr.length()];

        for (int i = 0; i < arr.length(); i++) {
            char letter = arr.charAt(i);
            int ix = alpha.get(letter);
            int nix = count[ix];
            count[ix]++;
            t[nix] = letter;
        }

        return new String(t);
    }

    private Map<Character, Integer> constructMap() {
        final Map<Character, Integer> alpha = HashMap.newHashMap(R);
        alpha.put('a', 0);
        alpha.put('b', 1);
        alpha.put('c', 2);
        alpha.put('d', 3);
        alpha.put('e', 4);
        alpha.put('f', 5);
        alpha.put('g', 6);
        alpha.put('h', 7);
        alpha.put('i', 8);
        alpha.put('j', 9);
        alpha.put('k', 10);
        alpha.put('l', 11);
        alpha.put('m', 12);
        alpha.put('n', 13);
        alpha.put('o', 14);
        alpha.put('p', 15);
        alpha.put('q', 16);
        alpha.put('r', 17);
        alpha.put('s', 18);
        alpha.put('t', 19);
        alpha.put('u', 20);
        alpha.put('v', 21);
        alpha.put('w', 22);
        alpha.put('x', 23);
        alpha.put('y', 24);
        alpha.put('z', 25);
        alpha.put(' ', 26);
        alpha.put('.', 27);
        alpha.put(',', 28);
        alpha.put('!', 29);
        alpha.put('?', 30);
        return Collections.unmodifiableMap(alpha);
    }
}
