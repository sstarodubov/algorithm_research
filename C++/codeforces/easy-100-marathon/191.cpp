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
#include <csignal>
#include "helper.h"
#include <tuple>
#include <queue>
#include <bitset>

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int ans = 0;
        while (n > 0) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
};

int main() {
    cout << Solution().hammingWeight(34);
    return 0;
}

