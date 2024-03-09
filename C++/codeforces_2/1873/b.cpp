#include<iostream>

#include <cstdint>

using namespace std;

// 1873
int t, n, a[10];

void resolve() {
    cin >> n;
    int m = INT32_MAX;
    int r = 0;
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        if (a[i] < m) {
            m = a[i];
            r = i;
        }
    }

    a[r]++;

    int ret = 1;

    for (int i = 0; i < n; ++i) {
        ret *= a[i];
    }

    cout << ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
