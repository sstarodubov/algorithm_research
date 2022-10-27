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
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; ++i) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int wr = nums1.size() - 1, pl = m - 1, pr = n - 1;

        while (pl >= 0 && pr >= 0) {
            if (nums1[pl] > nums2[pr]) {
                nums1[wr] = nums1[pl];
                pl--;
            } else {
                nums1[wr] = nums2[pr];
                pr--;
            }
            wr--;
        }

        while (pl >= 0) {
            nums1[wr--] = nums1[pl--];
        }

        while (pr >= 0) {
            nums1[wr--] = nums2[pr--];
        }
    }
};

int main() {
    vi nums1 = {2, 0};
    int m = 1;
    vi nums2 = {1};
    int n = 1;

    Solution().merge(nums1, m, nums2, n);
    return 0;
}

