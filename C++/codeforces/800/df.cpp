#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>

using namespace std;

bool contains(unordered_set<int> &set, int &val) {
    return set.find(val) != set.end();
}

typedef vector<int> vi;
typedef vector<vector<int>> vvi;
typedef long long ll;

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
    int n, m;
    cin >> n;
    cin >> m;

    int ans = 0;

    double b;
    for (int a = 0; a <= n; ++a) {
        b = n - (a * a);
        if (b < 0) continue;
        if (b * b == m - a) {
            ans++;
        }
    }
    cout << ans;

    return 0;
}
