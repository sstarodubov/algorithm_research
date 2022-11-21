#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

bool contains(unordered_set<int>& set, int& val) {
    return set.find(val) != set.end();
}

typedef vector<int> vi;
typedef vector<vector<int>> vvi;


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
    int arr[n];
    read_arr(n, arr);
    unordered_set<int> set;
    for (int i = 0; i < n; ++i) {
        if (contains(set, arr[i])) {
            cout << "NO" << endl;
            return;
        } else {
            set.insert(arr[i]);
        }
    }

    cout << "YES" << endl;
}



