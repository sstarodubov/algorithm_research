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

int max(int *a, int n) {
    int imx = 0;
    for (int i = 1; i < n; ++i) {
        if (a[i] > a[imx]) {
            imx = i;
        }
    }

    return imx;
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
    int b[n];

    read_arr(n, a);
    read_arr(n, b);

    int tm;
    for (int i = 0; i < n; ++i) {
        if (a[i] < b[i]) {
            tm = a[i];
            a[i] = b[i];
            b[i] = tm;
        }
    }

    int i = max(a, n);
    int j = max(b, n);

    ll ans = a[i] * b[j];
    cout << ans << endl;
}
