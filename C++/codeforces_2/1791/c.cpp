#include<iostream>
#include <unordered_set>

using namespace std;

int t;

void resolve() {
    int n;
    string s;
    cin >> n;
    cin >> s;

    int l = 0, r = n - 1, ret = n;

    while (l < r) {

        if (s[l] == s[r]) {
            break;
        }

        ret -= 2;
        l++;
        r--;
    }

    cout << ret << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
