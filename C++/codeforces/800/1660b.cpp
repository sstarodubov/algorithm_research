#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <array>
#include <cmath>
#include <iterator>


using namespace std;

typedef vector<int> vi;
typedef vector<vector<int>> vvi;
typedef long long ll;

void solve();

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(ll n, ll *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; ++i)
        solve();

    return 0;
}


void solve() {
    int n;
    cin >> n;
    int arr[n];
    read_arr(n, arr);


    if (n == 1) {
        if (arr[0] == 1) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    } else {
        int mx = INT32_MIN;
        int mmx = INT32_MIN;

        for (int i = 0; i < n; ++i) {
            if (mx <= arr[i]) {
                mmx = mx;
                mx = arr[i];
            } else if (mmx < arr[i]) {
                mmx = arr[i];
            }
        }

        if ((mx - mmx ) <= 1) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
}
