import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BoyOrGirl {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var set = new HashSet<Character>();

        int ch;
        while ((ch = in.read()) != -1) {
            char letter = (char) ch;
            if (Character.isAlphabetic(letter)) {
                set.add(letter);
            }
        }

        if ((set.size() & 1) == 1) {
            System.out.println("IGNORE HIM!");
        } else {
            System.out.println("CHAT WITH HER!");
        }
    }
}
