import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Dijkstra {
    record Pair(char node, int dist) implements Comparable<Pair> {

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) {
        Map<Character, Map<Character, Integer>> graph = Map.of(
                'A', Map.of('B', 3, 'C', 1),
                'C', Map.of('D', 6, 'B', 2),
                'B', Map.of('W', 2, 'U', 10),
                'D', Map.of('U', 1),
                'W', Map.of('U', 1),
                'U', Map.of()
        );


        doDijkstra(graph, 'C', 'W');
    }


    public static void doDijkstra(Map<Character, Map<Character, Integer>> graph, char start, char end) {
        var pq = new PriorityQueue<Pair>();
        var dist = new HashMap<Character, Integer>();
        dist.put(start, 0);
        pq.add(new Pair(start, 0));
        var visit = new HashSet<Character>();
        visit.add(start);

        while (!pq.isEmpty()) {
            var curPair = pq.poll();
            visit.add(curPair.node());
            var neighborhood = graph.get(curPair.node());
            for (var neighbor : neighborhood.keySet()) {
                if (visit.contains(neighbor)) {
                    continue;
                }
                var costEdge = graph.get(curPair.node()).get(neighbor);
                var newDist = dist.getOrDefault(curPair.node(), MAX_VALUE) + costEdge;
                if (newDist < dist.getOrDefault(neighbor, MAX_VALUE)) {
                    dist.put(neighbor, newDist);
                    pq.add(new Pair(neighbor, newDist));
                }
            }
        }

        System.out.println(dist.get(end));
    }
}
