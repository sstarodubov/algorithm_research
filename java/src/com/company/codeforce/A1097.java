import java.util.Scanner;

public class A1097 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        var cd = sc.next();
        String[] de = new String[5];
        for (int i = 0; i < 5; i++) {
            de[i] = sc.next();
        }

        for (int i = 0; i < de.length; i++) {
            if (de[i].charAt(0) == cd.charAt(0) || de[i].charAt(1) == cd.charAt(1)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    int greaterCommonDeviser(int a, int b) {
        int R;
        while ((a % b) > 0) {
            R = a % b;
            a = b;
            b = R;
        }
        return b;
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
