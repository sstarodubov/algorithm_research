#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>

using namespace std;

void read_arr_long(int n, long long *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void read_arr(int n, int *a) {
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
}

void print_arr(int n, int *arr) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";

        if (i == n - 1) {
            cout << endl;
        }
    }
}

void solve();

typedef long long ll;
typedef long double ld;

class Solution {
public:
    bool isPalindrome(int x) {

        long long n = x;
        long long r = 0;
        while (x > 0) {
            int d = x % 10;
            r = d + r * 10;
            x /= 10;
        }

        return n == r;
    }
};

int main() {
    cout << Solution().isPalindrome(101);
    return 0;
}
