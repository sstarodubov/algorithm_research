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
    int mySqrt(int x) {
        long long l = 0, r = x, m, mm, mm1;
        while (l <= r) {
            m = l + (r - l) / 2;
            mm = m * m;
            mm1 = (m + 1) * (m + 1);
            if (mm <= x && mm1 > x) return m;
            else if (mm > x && mm1 > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    };

};

int main() {

    cout << Solution().mySqrt(25);

    return 0;
}

