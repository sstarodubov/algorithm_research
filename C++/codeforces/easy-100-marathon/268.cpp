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
    int missingNumber(vector<int> &nums) {
        unordered_set<int> set;

        for(auto& el: nums) {
            set.emplace(el);
        }

        for (int i = 0; i <= nums.size(); ++i) {
            if (set.find(i) == set.end()) {
                return i;
            }
        }
    }
};


int main() {
    vi v = { 0, 1};
    cout << Solution().missingNumber(v);
    return 0;
}

