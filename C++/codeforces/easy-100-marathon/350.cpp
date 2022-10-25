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
    vector<int> intersect(vector<int> &nums1, vector<int> &nums2) {
        unordered_map<int, int> m;
        vector<int> ans;

        for (int &i: nums1) {
            m[i] += 1;
        }

        for(int &n : nums2) {
            if (m.find(n) == m.end()) {

            } else {
                if (m[n] > 0) {
                    m[n]--;
                    ans.push_back(n);
                }
            }
        }

        return ans;
    }
};


int main() {
    vi v1 = {1,2,2,1};
    vi v2 = {2,2};
    auto ans = Solution().intersect(v1, v2);
    return 0;
}

