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
    ll n;
    cin >> n;
    deque<int> dq;

    while (n > 0) {
        int l = n % 10;
        dq.push_front(l);
        n /= 10;
    }

    int L = dq.size();

    if ((dq.at(L - 1) & 1) == 0) {
        cout << 0 << endl;
        return;
    }

    if ((dq.at(0) & 1) == 0) {
        cout << 1 << endl;
        return;
    }

    for (int i = 1; i < L - 1; ++i) {
        if ((dq.at(i) & 1) == 0) {
            cout << 2 << endl;
            return;
        }
    }
    cout << -1 << endl;
}