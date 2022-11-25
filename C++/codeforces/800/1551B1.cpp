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
    string s;
    cin >> s;
    unordered_map<char, int> mp;

    for (int i = 0; i < s.size(); ++i) {
        mp[s[i]] += 1;
    }

    if (mp.size() == 1) {
        int k = mp.begin()->second;
        if (k >= 2) {
            cout << 1 << endl;
        } else {
            cout << 0 << endl;
        }
        return;
    }

    int ans = 0;
    int cur = 0;
    for (auto &[k,v] : mp) {
        if (v >=2) {
            ans++;
            continue;
        }
        if (v == 1) {
            cur += 1;
            if (cur == 2) {
                cur = 0;
                ans++;
            }
        }
    }

    cout << ans << endl;
}
