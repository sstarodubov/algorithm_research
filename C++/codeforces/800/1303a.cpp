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

    int begin = -1;
    int end = -1;


    for (int i = 0; i < s.size(); ++i) {
        if (s[i] == '1') {
            begin = i;
            break;
        }
    }

    for (int i = s.size() - 1; i >= 0; --i) {
        if (s[i] == '1') {
            end = i;
            break;
        }
    }

    if (begin == -1) {
        cout << 0 << endl;
        return;
    }

    int ans = 0;
    for (int i = begin + 1; i < end; ++i) {
        if (s[i] == '0') {
            ans++;
        }
    }

    cout << ans << endl;
}
