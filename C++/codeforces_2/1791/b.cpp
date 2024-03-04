#include<iostream>
#include <unordered_set>

using namespace std;

int t;
typedef long long ll;

void resolve() {
    ll a1, a2, a3, a4;

    cin >> a1;
    cin >> a2;
    cin >> a3;
    cin >> a4;

    if (a1 == 0) {
        cout << 1 << endl;
        return;
    }

    ll ret = 0;
    ret += a1;

    ll mn = min(a2, a3);
    ret += (mn * 2);

    ll mx = max(a2, a3);

    ll d = (mx - mn) + a4;
    if (a1 < d) {
        ret += a1 + 1;
    }
    else if (a1 == d) {
        ret += a1;
    }
    else {
        ret += d ;
    }
    cout << ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
