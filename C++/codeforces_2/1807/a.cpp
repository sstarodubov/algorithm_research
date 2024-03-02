#include<iostream>
using namespace std;

int t, a, b, c;

int main() {
    cin >> t;
    while (t-- > 0) {
        cin >> a;
        cin >> b;
        cin >> c;
        if ((a + b) == c) {
            cout << "+" << endl;
        }
        else {
            cout << "-" << endl;
        }
    }
}
