
#include "vector"

using namespace std;

const int MAXN = 8;

int n, bridges, par[MAXN], bl[MAXN], comp[MAXN], sz[MAXN];

void init() {
    for (int i = 0; i < n; ++i) {
        bl[i] = comp[i] = i;
        sz[i] = 1;
        par[i] = -1;
    }
    bridges = 0;
}


int get(int v) {
    if (v == -1) return -1;
    return bl[v] == v ? v : bl[v] = get(bl[v]);
}

int get_comp(int v) {
    v = get(v);
    return comp[v] == v ? v : comp[v] = get_comp(comp[v]);
}

void make_root(int v) {
    v = get(v);
    int root = v,
            child = -1;
    while (v != -1) {
        int p = get(par[v]);
        par[v] = child;
        comp[v] = root;
        child = v;
        v = p;
    }
    sz[root] = sz[child];
}


int cu, u[MAXN];

void merge_path(int a, int b) {
    ++cu;

    vector<int> va, vb;
    int lca = -1;
    for (;;) {
        if (a != -1) {
            a = get(a);
            va.push_back(a);

            if (u[a] == cu) {
                lca = a;
                break;
            }
            u[a] = cu;

            a = par[a];
        }

        if (b != -1) {
            b = get(b);
            vb.push_back(b);

            if (u[b] == cu) {
                lca = b;
                break;
            }
            u[b] = cu;

            b = par[b];
        }
    }

    for (size_t i = 0; i < va.size(); ++i) {
        bl[va[i]] = lca;
        if (va[i] == lca) break;
        --bridges;
    }
    for (size_t i = 0; i < vb.size(); ++i) {
        bl[vb[i]] = lca;
        if (vb[i] == lca) break;
        --bridges;
    }
}


void add_edge(int a, int b) {
    a = get(a);
    b = get(b);
    if (a == b) return;

    int ca = get_comp(a),
            cb = get_comp(b);
    if (ca != cb) {
        ++bridges;
        if (sz[ca] > sz[cb]) {
            swap(a, b);
            swap(ca, cb);
        }
        make_root(a);
        par[a] = comp[a] = b;
        sz[cb] += sz[a];
    } else
        merge_path(a, b);
}
