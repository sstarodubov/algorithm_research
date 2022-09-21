#include <iostream>
#include <map>

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
        solve();
    }


    return 0;
}

void solve() {
    int n;
    cin >> n;

    int arr[n];

    read_arr(n, arr);

    int ans = 0;

    for (int i = 1; i < n; ++i) {
        double mn = min(arr[i], arr[i - 1]);
        double mx = max(arr[i], arr[i - 1]);
        double d = mx / mn;

        if (d > 2) {
            int a = 0;
            int cur = (int) mn;
            while (cur < mx) {
                cur *= 2;
                if (cur >= mx) {
                    break;
                }
                a++;
            }

            ans += a;
        }
    }

    cout << ans << endl;
}
