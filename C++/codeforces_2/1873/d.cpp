#include<iostream>

using namespace std;

// 1873
int t;

void resolve() {
    int n, k;
    string s;
    cin >> n;
    cin >> k;
    cin >> s;

    int p = 0, ret = 0;
    while (p < n) {
        if (s[p] == 'B') {
            p += k;
            ret++;
        }
        else {
            p++;
        }
    }


    cout << ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
