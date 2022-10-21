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
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> ans;
        unordered_set<int> set;
        for (auto & n : nums) {
            set.insert(n);
        }

        for (int i = 1; i <= nums.size(); ++i) {
            if (set.find(i) == set.end()) {
                ans.push_back(i);
            }
        }

        return ans;
    }
};
int main() {
    vi v{3};
    cout << Solution().removeElement(v, 2);
    return 0;
}

