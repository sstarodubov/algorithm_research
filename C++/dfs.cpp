
#include <iostream>
#include "vector"

using namespace std;

void dfs(vector<vector<int>> *g, int cur, vector<int> *used) {
    if (used->at(cur) == 1) return;
    used->at(cur) = 1;
    cout << cur << endl;
    vector<int> children = g->at(cur);
    for (int child : children) {
        dfs(g, child, used);
    }
}