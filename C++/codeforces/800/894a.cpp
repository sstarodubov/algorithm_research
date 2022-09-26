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
    string st;

    cin >> st;
    int ans = 0;
    for (int i = 0; i < st.size(); ++i) {
        for (int j = i + 1; j < st.size(); ++j) {
            for (int k = j + 1; k < st.size(); ++k) {
                if (st[i] == 'Q' && st[j] == 'A' && st[k] == 'Q') {
                    ans++;
                }
            }
        }
    }

    cout << ans << endl;

    return 0;
}


void solve() {

}