#include<iostream>
#include <unordered_set>

using namespace std;

int t;

void resolve() {
    int n;
    string s;
    cin >> n;
    cin >> s;

    int x = 0, y = 0;
    char d;
    for (int i = 0; i < n; ++i) {
        d = s[i];
        if (d == 'U') {
            y++;
        }
        else if (d == 'D') {
            y--;
        }
        else if (d == 'R') {
            x++;
        }
        else if (d == 'L') {
            x--;
        }
        if (x == 1 && y == 1) {
            cout << "yes" << endl;
            return;
        }
    }


    cout << "no" << endl;
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
