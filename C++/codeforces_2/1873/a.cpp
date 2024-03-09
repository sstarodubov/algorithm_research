#include <algorithm>
#include<iostream>
#include <vector>

using namespace std;

int t;
string a = "abc";

void resolve() {
    string s;
    cin >> s;
    int k = 0;

    for (int i = 0; i < 3; ++i) {
        if (s[i] != a[i]) {
            k++;
        }
    }

    if (k <= 2) {
        cout << "yes" << endl;
    } else {
        cout << "no" << endl;
    }
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
