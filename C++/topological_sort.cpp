
#include <algorithm>
#include "vector"

using namespace std;

typedef vector<vector<int>> vii;
typedef vector<int> vi;


void traverse(int v, vector<bool>& used, vii& g, vi& ans) {
    used[v] = true;
    for (size_t i = 0; i < g[v].size(); ++i) {
        int to = g[v][i];
        if (!used[to])
            traverse(to, used, g, ans);
    }
    ans.push_back(v);
}

void topological_sort(vii &graph, vector<bool> &visited, vi& ans) {
    for (int i = 0; i < graph.size(); ++i) {
        visited[i] = false;
    }
    ans.clear();
    for (int i = 0; i < graph.size(); ++i) {
        if (!visited[i]) {
            traverse(i, visited, graph, ans);
        }
    }
}

