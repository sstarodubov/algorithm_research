package p800;

import java.util.*;

public class A490 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var hm = new HashMap<Integer, Deque<Integer>>();

        for (int i = 0; i < n; i++) {
            int j = sc.nextInt();
            var dq = hm.getOrDefault(j, new ArrayDeque<>());
            dq.push(i + 1);
            hm.put(j, dq);
        }
        Deque<Integer> one = hm.getOrDefault(1, new ArrayDeque<>());
        Deque<Integer> two = hm.getOrDefault(2, new ArrayDeque<>());
        Deque<Integer> three = hm.getOrDefault(3, new ArrayDeque<>());

        int ans = Math.min(one.size(), Math.min(two.size(), three.size()));
        System.out.println(ans);

        while (ans > 0) {
            System.out.printf("%d %d %d\n",one.pop(), two.pop(), three.pop());
            ans--;
        }
    }
}
