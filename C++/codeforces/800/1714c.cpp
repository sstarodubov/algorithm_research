#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <array>
#include <cmath>
#include <iterator>


using namespace std;

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

void read_arr(ll n, ll *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}



void string_from_v(vector<int> &v) {
    string ans;
    for (int i = v.size() - 1; i >= 0; --i) {
        ans += to_string(v[i]);
    }

    cout << ans << endl;
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
    int s;
    cin >> s;
    int n = 9;
    int sum = 0;
    vector<int> v;
    while (true) {
        int t = sum + n;
        if (t == s) {
            v.push_back(n);
            string_from_v(v);
            return;
        } else if (t < s) {
            v.push_back(n);
            sum = sum + n;
        }
        n--;
    }
}
