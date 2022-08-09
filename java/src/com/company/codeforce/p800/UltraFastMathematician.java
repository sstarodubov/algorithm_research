package p800;

import java.math.BigInteger;
import java.util.Scanner;

public class UltraFastMathematician {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        var n = sc.next();
        var n1 = new BigInteger(n, 2);
        var n2 = sc.nextBigInteger(2);

        System.out.println(
                String.format("%" + n.length() + "s", n2.xor(n1).toString(2)).replace(' ', '0')
        );
    }
}
