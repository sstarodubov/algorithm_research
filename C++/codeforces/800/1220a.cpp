#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
#include <array>
#include <cmath>
#include <iterator>


using namespace std;

typedef vector<int> vi;
typedef vector<vector<int>> vvi;
typedef long long ll;

void solve();

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(ll n, ll *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

int main() {
    int z = 0;
    int n = 0;

    int L;
    cin >> L;
    string s;
    cin >> s;

    for(int i = 0; i < s.size(); ++i) {
        if (s[i] == 'z') z++;
        else if (s[i] == 'n') n++;
    }

    while (n-- > 0) {
        cout << 1 << " ";
    }

    while (z-- > 0) {
        cout << 0 << " ";
    }

    return 0;
}


void solve() {

}
