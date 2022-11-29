#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>

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
    int a, b, c, x, y;
    cin >> a;
    cin >> b;
    cin >> c;
    cin >> x;
    cin >> y;

    int dgs = x - a;
    int cats = y - b ;

    if (dgs > 0) {

        if (dgs - c > 0) {
            cout << "NO" << endl;
            return;
        }
        c  = c - dgs;
    }

    if (cats > 0) {
        if (cats - c > 0) {
            cout << "NO" << endl;
            return;
        }
    }

    cout << "YES" << endl;
}
