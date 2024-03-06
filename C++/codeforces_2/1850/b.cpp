#include <algorithm>
#include<iostream>

using namespace std;

int t, n;

struct triple {
    int a;
    int b;
    int c;
} typedef triple;

triple arr[50];

void resolve() {
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> arr[i].a;
        cin >> arr[i].b;
        arr[i].c = i + 1;
    }

    sort(arr, arr + n, [](triple x, triple y) {
        return x.b > y.b;
    });

    for (int i = 0; i < n; ++i) {
        if (arr[i].a <= 10) {
            cout << arr[i].c << endl;
            return;
        }
    }
}

int main() {
    cin >> t;
    while (t-- > 0) {
        resolve();
    }
}
