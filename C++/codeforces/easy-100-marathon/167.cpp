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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int l = 0, r = numbers.size() - 1, m;

        while (l < r) {
            m = numbers[l] + numbers[r];
            if (m == target) return {l, r};
            if (m > target) {
                r--;
            } else {
                l++;
            }
        }

        return {-1, -1};
    }
};

int main() {
    vi v = {2, 3 ,4};
    auto ans = Solution().twoSum(v, 6);

    return 0;
}

