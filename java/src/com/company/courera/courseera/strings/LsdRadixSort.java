package strings;

import java.util.Arrays;

public class LsdRadixSort {

    public static void main(String[] args) {
        var strs = new String[] {"hell", "word", "gorn", "argo"};
        sort(strs, 4);
        System.out.println(Arrays.toString(strs));
    }
    public static void sort(String[] a, int L) {
        int R = 256;
        int N = a.length;

        String[] out = new String[N];

        for (int d = L - 1; d >= 0 ; d--) {
            int[] count = new int[R + 1];

            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; i++) {
                out[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                a[i] = out[i];
            }
        }
    }
}
