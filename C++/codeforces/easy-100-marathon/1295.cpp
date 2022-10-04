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
    int findNumbers(vector<int> &nums) {
        int ans = 0;
        int k;
        for (auto n: nums) {
            k = 0;

            while (n > 0) {
                n = n / 10;
                k++;
            }

            if ((k & 1) == 0) ans++;
        }

        return ans;
    }
};

int main() {
    vi v = {12, 345, 2, 6, 7896};
    cout << Solution().findNumbers(v);

    return 0;
}

