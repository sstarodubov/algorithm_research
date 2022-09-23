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
    int dn = 0;
    int d = n;
    while (d != 0) {
        dn++;

        d /= 10;
    }

    int limit = pow(10, dn);
    int start = pow(10, dn - 1);
    int cur = start;
    int ans = INT32_MAX;
    int result = 7;
    while (cur < limit) {
        if (cur % 7 == 0) {
            int s = cur;
            int cs = n;
            int counter = 0;
            while (s != 0) {
                if (cs % 10 != s % 10) {
                    counter++;
                }
                s /= 10;
                cs /= 10;
            }

            if (counter < ans) {
                ans = counter;
                result = cur;
            }

        }
        cur++;
    }

    cout << result << endl;
}



