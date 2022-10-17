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
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2) {
        std::sort(nums1.begin(), nums1.end());
        std::sort(nums2.begin(), nums2.end());
        vector<int> ans;

        int l = 0, r = 0;

        while (l < nums1.size() && r < nums2.size()) {
            if (nums1[l] > nums2[r]) {
                while (r < nums2.size() && nums2[r] < nums1[l]) {
                    r++;
                }
            } else if (nums1[l] < nums2[r]) {
                while (l < nums1.size() && nums1[l] < nums2[r]) {
                    l++;
                }
            } else {
                if (ans.empty()) {
                    ans.push_back(nums2[r]);
                } else {
                    if (ans[ans.size() - 1] != nums2[r]) {
                        ans.push_back(nums2[r]);
                    }
                }

                r++;
                l++;
            }

        }

        return ans;
    }
};

int main() {

    vi v1 = {4,9,5};
    vi v2 = {9,4,9,8,4};

    auto a = Solution().intersection(v1, v2);
    return 0;
}

