import java.util.HashSet;
import java.util.Scanner;

public class BeautifulYear {

    private final static HashSet<Integer> set = new HashSet<>(4);

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        int y = sc.nextInt();

        for (int i = y + 1; ; i++) {
            if (uniq(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean uniq(int num) {
        set.clear();

        while (num != 0) {
            int ld = num % 10;
            if (set.contains(ld)) {
                return false;
            }
            set.add(ld);
            num /= 10;
        }

        return true;
    }
}
