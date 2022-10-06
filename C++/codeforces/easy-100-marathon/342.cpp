#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>
#include <unordered_map>
#include <cstring>
#include <algorithm>
#include "helper.h"

using namespace std;

typedef vector<int> vi;


class Solution {
public:
    bool isPowerOfFour(int n) {
        if (n == 1) return true;
        long long l = 1, r = n, m, p;

        while (l <= r) {
            m = (l + r) / 2;
            if (m >= 64) {
                r = m - 1;
                continue;
            }
            p = pow(4, m);
            if (p == n) return true;

            if (p > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }
};

int main() {
    vi v = {1, 3, 5, 6};
    cout << Solution().isPowerOfFour(126);
    return 0;
}

