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

    ll n, x;

    cin >> n;
    cin >> x;

    string t;
    ll pc = 0, r = 0, d = 0;

    for (int i = 0; i < n; ++i) {

        cin >> t;
        cin >> d;

        if (t == "+") {
            x += d;
        } else {
            r = x - d;
            if (r < 0) {
                pc++;
            } else {
                x -= d;
            }

        }
    }

    cout << x << " " << pc << endl;
    return 0;
}


void solve() {

}



