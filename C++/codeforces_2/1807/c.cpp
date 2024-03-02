#include<iostream>
#include <unordered_map>
using namespace std;

int t, n;

void resolve() {
    cin >> n;
    string s;
    cin >> s;

    unordered_map<char, int> m;

    for (int i = 0; i < n; ++i) {
        if ((i & 1) == 0) {
            if (m.contains(s[i])) {
                if (m[s[i]] != 0) {
                    cout << "NO" << endl;
                    return;
                }
            }
            else {
                m[s[i]] = 0;
            }
        }
        else {
            if (m.contains(s[i])) {
                if (m[s[i]] != 1) {
                    cout << "NO" << endl;
                    return;
                }
            }
            else {
                m[s[i]] = 1;
            }
        }
    }

    cout << "YES" << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
