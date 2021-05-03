#include <utility>


typedef vector<int> vi;
typedef vector<vi> vii;

class BridgeFinder {

public:
    int size;
    vii graph;
    vector<bool> used;
    int timer = 0;
    vi tin;
    vi fup;

    explicit BridgeFinder(vii &g) : graph(g) {
        this->size = g.size();
        this->used.assign(this->size, false);
        this->tin.assign(this->size, 0);
        this->fup.assign(this->size, 0);
    }

    void dfs(int v, int p = -1) {
        used[v] = true;
        tin[v] = fup[v] = timer++;
        for (size_t i = 0; i < this->graph[v].size(); ++i) {
            int to = this->graph[v][i];
            if (to == p) continue;
            if (used[to]) {
                fup[v] = min(fup[v], tin[to]);
            }
            else {
                dfs(to, v);
                fup[v] = min(fup[v], fup[to]);
                if (fup[to] > tin[v]) {
                    cout << "(" + to_string(v) + ", " + to_string(to) + ")";
                }
            }
        }
    }


    void find_bridges() {
        for (int i = 0; i < this->size; ++i) {
            if (!used[i]) dfs(i);
        }
    }
};