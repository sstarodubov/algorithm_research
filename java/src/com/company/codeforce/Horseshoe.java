import java.util.HashSet;
import java.util.Scanner;

public class Horseshoe {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        var set = new HashSet<Integer>();
        for (int i = 0; i < 4; i++) {
            set.add(sc.nextInt());
        }
        System.out.println(4 - set.size());
    }
}
