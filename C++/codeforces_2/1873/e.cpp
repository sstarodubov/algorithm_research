#include<iostream>
#include <vector>


using namespace std;
typedef unsigned long long ll;
// 1873
int t, n, x;

void resolve() {
    cin >> n;
    cin >> x;
    auto a = vector<int>(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    ll r = 1e15, l = 0;
    while (l < r - 1) {
        ll t = 0;
        ll m = l + (r - l) / 2;
        for (ll i = 0; i < n; ++i) {
            if (a[i] < m) {
                t += (m - a[i]);
            }
        }

        if (t > x) {
            r = m;
        }
        else {
            l = m;
        }
    }


    cout << l << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
