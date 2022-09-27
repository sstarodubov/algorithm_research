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
    int n;

    cin >> n;

    string row;
    string a[n];
    bool found = false;
    for (int i = 0; i < n; ++i) {
        cin >> row;

        if (!found && row[0] == 'O' && row[1] == 'O') {
            row[0] = '+';
            row[1] = '+';
            cout << "YES" << endl;
            found = true;
        } else if (!found && row[3] == 'O' && row[4] == 'O') {
            row[3] = '+';
            row[4] = '+';
            cout << "YES" << endl;
            found = true;
        }
        a[i] = row;
    }

    if (!found) {
        cout << "NO" << endl;
    } else {
        for (int i = 0; i < n; ++i) {
            cout << a[i] << endl;
        }
    }
    return 0;
}

void solve() {

}