#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <array>
#include <cmath>

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
    int k2, k3, k5, k6;

    cin >> k2;
    cin >> k3;
    cin >> k5;
    cin >> k6;

    int m = min(k2, min(k5, k6));
    int kr2 = k2 - m;

    int t = min(kr2, k3);
    cout << (32 * t) + (256 * m);

    return 0;
}

void solve() {
}
