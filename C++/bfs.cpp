
#include <iostream>
#include "vector"
#include "queue"

using namespace std;

void bfs(std::vector<std::vector<int>> &graph, int s) {
    int visited[graph.size()] = {0};
    queue<int> q;
    q.push(s);
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        cout << cur;
        visited[cur] = true;

        vector<int> children = graph.at(cur);

        for (int child : children) {
            if (!visited[child]) {
                q.push(child);
            }
        }
    }
}