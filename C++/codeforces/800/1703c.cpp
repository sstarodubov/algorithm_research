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

    int a[n];
    int ans[n];

    read_arr(n, a);

    int nn;
    string d;
    for (int i = 0; i < n; ++i) {

        cin >> nn;
        cin >> d;
        int cur = a[i];
        for (int j = 0; j < nn; ++j) {
            if (d[j] == 'D') {
                if (cur >= 9) cur = 0;
                else cur++;
            } else {
                if (cur <= 0) cur = 9;
                else cur--;
            }
        }

        ans[i] = cur;
    }

    print_arr(n, ans);
}