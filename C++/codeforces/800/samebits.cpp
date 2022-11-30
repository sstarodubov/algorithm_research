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

    int arr[n];

    read_arr(n, arr);

    int k = arr[0] & 1;
    int r = arr[1] & 1;

    if ((k == 1 && r == 1) || (k == 0 && r == 0)) {
        for (int i = 1; i < n; ++i) {
            if ((arr[i] & 1) != (arr[i - 1] & 1)) {
                cout << "NO" << endl;
                return;
            }
        }
        cout << "YES" << endl;
        return;
    }

    for (int i = 2; i < n; i += 2) {
        if ((arr[i] & 1) != k) {
            cout << "NO" << endl;
            return;
        }
    }

    for (int i = 3; i < n; i += 2) {
        if ((arr[i] & 1) != r) {
            cout << "NO" << endl;
            return;
        }
    }

    cout << "YES" << endl;
}
