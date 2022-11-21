#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef vector<int> vi;
typedef vector<vector<int>> vvi;


void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
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
    int a, b, c;

    cin >> a;
    cin >> b;
    cin >> c;

    if ((a +  b) == c) {
        cout << "YES" << endl;
    } else if (a + c == b) {
        cout << "YES" << endl;
    } else if (c + b == a){
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}

