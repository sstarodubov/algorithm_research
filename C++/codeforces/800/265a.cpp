#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

bool contains(unordered_set<int> &set, int &val) {
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

    string s, t;

    cin >> s;
    cin >> t;

    int p = 0;
    for (int i = 0; i < t.length(); ++i) {
        if (t[i] == s[p]) {
            p++;
        }
    }

    cout << p + 1;
    return 0;
}

