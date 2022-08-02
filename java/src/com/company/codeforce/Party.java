import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Party {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        var gr = new HashMap<Integer, Set<Integer>>();
        for (int i = 1; i <= n; i++) {
            gr.put(i, new HashSet<>());
        }
        for (int i = 1; i <= n; i++) {
            var mg = sc.nextInt();
            if (mg != -1) {
                gr.get(mg).add(i);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int p = dfs(gr, i, 1);
            ans = Math.max(ans, p);
        }

        System.out.println(ans);
    }

    private static int dfs(HashMap<Integer, Set<Integer>> tree, Integer node, int depth) {
        var children = tree.get(node);
        if (children.isEmpty()) return depth;
        int ans = 0;
        for (int child : children) {
            ans = Math.max(dfs(tree, child, depth + 1), ans);
        }
        return ans;
    }
}
