package p1200;

import java.util.Arrays;
import java.util.Scanner;

public class B489 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int n = sc.nextInt();
        var ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        var ms = new int[m];

        for (int i = 0; i < m; i++) {
            ms[i] = sc.nextInt();
        }

        Arrays.sort(ns);
        Arrays.sort(ms);

        int n_ptr = 0, m_ptr = 0, res = 0, mv, nv;
        while ((n_ptr < n) && (m_ptr < m)) {
            mv = ms[m_ptr];
            nv = ns[n_ptr];
            if (Math.abs(mv - nv) <= 1) {
                res++;
                m_ptr++;
                n_ptr++;
            } else {
                if (mv < nv) {
                    m_ptr++;
                } else {
                    n_ptr++;
                }
            }
        }

        System.out.println(res);
    }
}
