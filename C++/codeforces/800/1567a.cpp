#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>

using namespace std;

void read_arr_long(int n, long long *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}

void solve();

typedef long long ll;
typedef long double ld;

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

    char ans[n];

    for (int i = 0; i < n; ++i) {
        if (s[i] == 'L') {
            ans[i] = 'L';
        } else if (s[i] == 'R') {
            ans[i] = 'R';
        }  else if (s[i] == 'U') {
            ans[i] = 'D';
        } else if (s[i] == 'D') {
            ans[i] = 'U';
        }
    }

    for (int i = 0; i < n; ++i) {
        cout << ans[i];
    }

    cout << endl;
}