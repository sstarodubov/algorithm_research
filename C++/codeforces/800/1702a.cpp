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
    ll m;
    cin >> m;

    int d = 0;
    ll k = m;
    while (k > 0) {
        d++;
        k /= 10;
    }

    ll round = pow(10, d - 1);

    cout << m - round << endl;
}



