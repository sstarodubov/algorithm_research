#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <array>

using namespace std;

bool contains(unordered_set<int> &set, int &val) {
    return set.find(val) != set.end();
}

typedef vector<int> vi;
typedef vector<vector<int>> vvi;
typedef long long ll;

void solve();

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

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
    int a[n];
    read_arr(n, a);

    unordered_map<int, int> map;
    unordered_map<int, int> idx;
    for (int i = 0; i < n; ++i) {
        map[a[i]] += 1;
        idx[a[i]] = i;
    }

    int mn = INT32_MAX;

    for (auto &[k,v] : map) {
        if (v == 1) {
            mn = min(mn, k);
        }
    }

    cout << (mn == INT32_MAX ? -1 : idx[mn] + 1) << endl;
}
