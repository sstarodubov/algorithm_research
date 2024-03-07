#include <algorithm>
#include<iostream>
#include <vector>

using namespace std;

int t, n, k;

void resolve() {
    cin >> n;
    cin >> k;
    auto v = vector<int>(n);
    for (int i = 0; i < n; ++i) {
        cin >> v[i];
    }

    sort(v.begin(), v.end());
    int ret = 0;
    int bp = 0;
    for (int i = 1; i < n; ++i) {
        if ((v[i] - v[i - 1]) > k) {
            ret = max(ret, i - bp);
            bp = i;
        }
    }

    ret = max(ret, n - bp);

    cout << n - ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
