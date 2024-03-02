#include <algorithm>
#include<iostream>
using namespace std;

int t, n;
int a[100];
void resolve() {
    cin >> n;
    int k = 0;
    int even = 0, odd = 0;
    for (int i = 0; i < n; ++i) {
        cin >> k;
        if (k % 2 == 0) {
            even += k;
        } else {
            odd += k;
        }
    }

    if (even > odd) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}


