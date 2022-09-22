#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>

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
    int ar[n];

    read_arr(n, ar);

    int mn = INT32_MAX;

    for (int i = 0; i < n; ++i) {
        if (mn > ar[i]) {
            mn = ar[i];
        }
    }
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        if (ar[i] != mn) ans ++;
    }
    cout << ans << endl;
}



