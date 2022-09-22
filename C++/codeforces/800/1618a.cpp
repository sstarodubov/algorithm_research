#include <iostream>
#include <map>
#include <cmath>
#include <string>

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
    ll a[7];

    read_arr_long(7, a);

    ll a1 = a[0];

    ll d = a[6] - a1;

    for (int i = 1; i < 6; ++i) {
        for (int j = i + 1; j < 6; ++j) {
            if (a[i] + a[j] == d) {
                cout << a1 << " ";
                cout << a[i] << " ";
                cout << a[j] << endl;
                return;
            }
        }
    }
}



