package p800;

import java.util.Scanner;

public class A151 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();

        int nl = sc.nextInt();
        int np = sc.nextInt();

        int kl = k * l;
        int cd = c * d;

        int bottles = kl / (n * nl);
        int slices = cd / n;
        int salt = p / (n * np);

        int min = Math.min(bottles, Math.min(salt, slices));
        System.out.println(min);
    }

    public static void print(int[] arr) {
        var s = new StringBuilder();
        for (int j : arr) {
            s.append(j).append(" ");
        }
        s.deleteCharAt(s.length() - 1);
        System.out.println(s);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
