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
    int firstBadVersion(int n) {
        if (n == 1) return 1;

        int l = 1, r = n, m;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (isBadVersion(m) && (!isBadVersion(m - 1) || m - 1 <= 0)) return m;

            if (!isBadVersion(m) && !isBadVersion(m - 1)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
};

int main() {

    cout << Solution().firstBadVersion(2);
    return 0;
}

