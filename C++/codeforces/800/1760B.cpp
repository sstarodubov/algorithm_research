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
    string s;
    cin >> s;

    string al = "abcdefghijklmnopqrstuvwxyz";
    unordered_map<char, int> map;
    for (int i = 0; i < al.size(); ++i) {
        map[al[i]] = i + 1;
    }

    char max = '\0';

    for (int i = 0; i < s.size(); ++i) {
        if (s[i] > max) {
            max = s[i];
        }
    }

    cout << map[max] << endl;

}
