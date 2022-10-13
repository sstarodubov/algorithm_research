import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    final Map<Integer, Map<Integer, Integer>> graph;
    final int from;
    final int to;
    final int[] distance;
    final int[] paths;

    record Rec(int node, int weight) {
    }

    public Dijkstra(Map<Integer, Map<Integer, Integer>> graph, int from, int to) {
        this.graph = graph;
        this.from = from;
        this.to = to;
        distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        paths = new int[graph.size()];
        Arrays.fill(paths, -1);
    }

    public void displayPath() {
        int cur = to;
        var path = new StringBuilder();
        while (cur != -1) {
            path.append(cur).append(" - ");
            cur = paths[cur];
        }
        System.out.println(path);
    }

    public int shortPath() {
        PriorityQueue<Rec> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        distance[from] = 0;
        pq.add(new Rec(from, 0));

        while (!pq.isEmpty()) {
            final var path = pq.poll();


            for (var entry : graph.get(path.node()).entrySet()) {

                int nodeTo = entry.getKey();
                int nodeToW = entry.getValue();
                int newWeight = distance[path.node] + nodeToW;

                if (newWeight < distance[nodeTo]) {
                    distance[nodeTo] = newWeight;
                    paths[nodeTo] = path.node;
                    pq.add(new Rec(nodeTo, newWeight));
                }
            }
        }
        return distance[to];
    }

    public static void main(String[] args) {
        final Map<Integer, Map<Integer, Integer>> graph = Map.of(
                0, Map.of(
                        1, 5,
                        7, 8,
                        4, 9),
                1, Map.of(
                        7, 4,
                        2, 12,
                        3, 15),
                2, Map.of(3, 3,
                        6, 11),
                3, Map.of(
                        6, 9),
                4, Map.of(
                        7, 5,
                        5, 4,
                        6, 20),
                5, Map.of(
                        2, 1,
                        6, 13),
                6, Map.of(),
                7, Map.of(
                        5, 6,
                        2, 7)
        );
        var sssp = new Dijkstra(graph, 0, 6);
        System.out.println(sssp.shortPath());
        sssp.displayPath();
    }
}
