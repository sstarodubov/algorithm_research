#include "vector"

using namespace std;
typedef vector<vector<pair<int, int>>> vvp;

// O(n^2 + m)
int dijkstra(vvp &g, int start, int end) {

    int n = g.size();
    int s = start;
    const int INF = 999999999;
    vector<int> distances(n, BIG_NUMBER), parents(n);
    distances[s] = 0;
    vector<bool> visited(n, false);

    for (int i = 0; i < n; ++i) {
        int v = -1;
        for (int j = 0; j < n; ++j)
            if (!visited[j] && (v == -1 || distances[j] < distances[v])) {
                v = j;
            }
        if (distances[v] == INF) {
            break;
        }
        visited[v] = true;

        for (size_t j = 0; j < g[v].size(); ++j) {
            int to = g[v][j].first, len = g[v][j].second;
            if (distances[v] + len < distances[to]) {
                distances[to] = distances[v] + len;
                parents[to] = v;
            }
        }
    }
    return distances[end];
}


