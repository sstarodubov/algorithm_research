#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <array>

using namespace std;

bool contains(unordered_set<int> &set, int &val) {
    return set.find(val) != set.end();
}

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

int main() {
    int t;

    cin >> t;

    for (int i = 0; i < t; ++i) {
        solve();
    }

    return 0;
}

void solve() {
    char in;

    array<array<char, 8>, 8> arr{};

    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            cin >> in;
            arr[i][j] = in;
        }
    }

    for (int i = 1; i < 7; ++i) {
        for (int j = 1; j < 7; ++j) {
            if (arr[i][j] == '#' && arr[i - 1][j - 1] == '#' && arr[i + 1][j + 1] == '#' && arr[i - 1][j + 1] == '#' &&
                arr[i + 1][j - 1] == '#') {
                cout << i + 1 << " " << j + 1 << endl;
                return;
            }
        }
    }
}
