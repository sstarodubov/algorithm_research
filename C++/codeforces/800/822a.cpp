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

ll f(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;

    int cur = 1;
    ll ans = 1;
    while (n-- >= 1) {
        ans = ans * cur;
        cur++;
    }

    return ans;
}
int main() {
    int a, b;
    cin >> a;
    cin >> b;
    int mn = min(a,b);
    cout << f(mn);
    return 0;
}
