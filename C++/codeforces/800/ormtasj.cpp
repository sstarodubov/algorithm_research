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

struct Pair {
    int l;
    int r;
};

int main() {
    int t;

    cin >> t;

    for (int i = 0; i < t; ++i) {
        solve();
    }

    return 0;
}

void solve() {
    int n, k;
    cin >> n;
    cin >> k;

    int a[n];

    read_arr(n, a);
    Pair arr[n];

    int v;
    for (int i = 0; i < n; ++i) {
        cin >> v;
        arr[i] = {a[i], v};
    }


    sort(arr, arr + n, [](const Pair &a ,const Pair &b){
        return a.l < b.l;
    });

    int ans = k;

    int i = 0;

    while (i < n && ans >= arr[i].l) {
        ans += arr[i++].r;
    }

    cout << ans << endl;
}
