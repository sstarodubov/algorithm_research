#include <iostream>
#include <map>

using namespace std;


std::map<int, int> m;

void solve() {

    int n;
    cin >> n;
    int arr[n];
    for (int j = 0; j < n; ++j) {
        int w;
        cin >> w;
        arr[j] = w;
    }
    for (int i = 0; i < n; ++i) {
        int p = arr[i];
        if (m.find(p) != m.end()) {
            m[p] = m[p] + 1;
            if (m[p] == 3) {
                cout << p << endl;
                m.clear();
                return;
            }
        } else {
            m[p] = 1;
        }
    }

    cout << -1 << endl;
    m.clear();
}

int main() {

    int t;
    cin >> t;

    for (int i = 0; i < t; ++i) {
        solve();
    }
    return 0;
}
