#include<iostream>

using namespace std;

int t;

void resolve() {
    int a, b, c;
    cin >> a;
    cin >> b;
    cin >> c;

    if ((a + b) >= 10) {
        cout << "yes" << endl;
    } else if ((a + c) >= 10) {
        cout << "yes" << endl;
    } else if ((c + b) >= 10) {
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
