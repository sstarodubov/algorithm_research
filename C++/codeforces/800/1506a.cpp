#include <iostream>
#include <map>
#include <cmath>

using namespace std;

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


int main() {
    int t;
    cin >> t;

    for (int i = 0; i < t; ++i) {
        long long x, n, m;

        cin >> n;
        cin >> m;
        cin >> x;

        auto xx = (long double) x;
        auto nn = (long double) n;

        long long c1 = ceil(xx / nn);

        long long r1 = x % n == 0 ? n : x % n;

        long long ans = (m * r1) - (m - c1);
        cout << ans << endl;
    }

    return 0;
}




