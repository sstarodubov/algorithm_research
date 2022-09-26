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
    ll a, b, c;

    cin >> a;
    cin >> b;
    cin >> c;

    if (a < b) {
        cout << 1 << endl;
    } else if (a == b) {
        if (c < b) {
            cout << 3 << endl;
        } else {
            cout << 1 << endl;
        }
    } else {
        if (c < b) {
            if (b > a) {
                cout << 1 << endl;
            } else if (a > b) {
                cout << 2 << endl;
            } else {
                cout << 3 << endl;
            }
        } else {
            ll s = (c - b) + c;
            if (s > a) {
                cout << 1 << endl;
            } else if (s == a) {
                cout << 3 << endl;
            } else {
                cout << 2 << endl;
            }
        }
    }
}