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


static int dp[101][101];

bool dfs(int x, int y, int k) {
    if (dp[x][y] != 0) {
        return dp[x][y] == 1;
    }
    if (x == 1 && y == 1 && k == 0) return true;
    if (k < 0) return false;
    if (x == 1 && y == 1) return false;
    if (x < 1) return false;
    if (y < 1) return false;

    bool a = dfs(x - 1, y, k - y);
    bool b = dfs(x, y - 1, k - x);
    bool ans = a || b;
    dp[x][y] = ans ? 1 : -1;

    return ans;
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
    int n, m, k;

    cin >> n;
    cin >> m;
    cin >> k;

    for (int i = 0; i < 101; ++i) {
        for (int j = 0; j < 101; ++j) {
            dp[i][j] = 0;
        }
    }

    if (dfs(n, m, k)) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}
