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
    int xa, ya, xb, yb, xf, yf;

    cin >> xa;
    cin >> ya;

    cin >> xb;
    cin >> yb;

    cin >> xf;
    cin >> yf;

    if (xa == xb) {
        if (xa == xf) {
            if (((ya > yf && yb < yf) || (yb > yf && ya < yf))) {
                cout << abs(ya - yb) + 2 << endl;
            } else {
                cout << abs(ya - yb) << endl;
            }
        } else {
            cout << abs(ya - yb) << endl;
        }
    } else if (ya == yb) {
        if (ya == yf) {
            if (((xa > xf && xb < xf) || (xb > xf && xa < xf))) {
                cout << abs(xa - xb) + 2 << endl;
            } else {
                cout << abs(xa - xb) << endl;
            }
        } else {
            cout << abs(xa - xb) << endl;
        }

    } else {
        int dx = abs(xa - xb);
        int dy = abs(ya - yb);
        cout << dx + dy << endl;
    }
}