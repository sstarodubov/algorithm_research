package p800;

import java.util.Map;
import java.util.Scanner;

public class A785 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        var m = Map.of(
                "Tetrahedron", 4,
                "Cube", 6,
                "Octahedron", 8,
                "Dodecahedron", 12,
                "Icosahedron", 20
        );
        int n = sc.nextInt();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += m.get(sc.next());
        }

        System.out.println(ans);
    }
}
