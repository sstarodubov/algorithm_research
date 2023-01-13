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
    int n;
    string s;

    cin >> n;
    cin >> s;

    int k = 0;
    string ans;
    for (int i = 0; i < n; i += k) {
        ans += s[i];
        k ++;
    }

    cout << ans ;
    return 0;
}


void solve() {
    string s;
    cin >> s;

    int ans = (s[0] + s[2]) - 96;
    cout << ans << endl;
}
