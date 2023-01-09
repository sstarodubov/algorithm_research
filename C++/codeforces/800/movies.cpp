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

    int ans = 0;

    for (int i = 0; i < n; ++i) {
        if (arr[i] == 1 || arr[i] == 3) {
            ans ++;
        }
    }

    cout << ans << endl;
}
