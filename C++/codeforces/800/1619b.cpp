#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

bool contains(unordered_set<int> &set, int &val) {
    return set.find(val) != set.end();
}

typedef vector<int> vi;
typedef vector<vector<int>> vvi;
typedef long long ll;

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}


void solve();

int main() {
    int t;
    cin >> t;

    for (int i = 0; i < t; ++i) {
        solve();
    }


    return 0;
}

void solve() {
    int n;
    cin >> n;
    unordered_set<ll> set;
    for (ll i = 1; i*i <= n; ++i) {
        set.insert(i * i);
    }

    for (ll i = 1; i*i*i <= n; ++i) {
        set.insert(i * i * i);
    }

    cout << set.size() << endl;
}