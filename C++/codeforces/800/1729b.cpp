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

void solve(unordered_map<string, string> map);

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

void read_arr(ll n, ll *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

int main() {
    int t;
    cin >> t;
    unordered_map<string, string> m;
    string a = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 0; i < a.size(); ++i) {
        m[to_string(i + 1)] = a[i];
    }

    for (int i = 0; i < t; ++i) {
        solve(m);
    }
    return 0;
}

void solve(unordered_map<string, string> m) {
    string s;
    int n;
    cin >> n;
    cin >> s;

    string ans;
    int p = s.size() - 1;
    string k;

    while (p >= 0) {
        if (s[p]== '0') {
            k.clear();
            k.push_back(s[p - 2]);
            k.push_back(s[p - 1]);
            ans += m[k];
            p -= 3;
        } else {
            ans += m[string (1, s[p])];
            p--;
        }

    }
    reverse(ans.begin(), ans.end());
    cout << ans  << endl;
}
