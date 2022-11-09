#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-convert-member-functions-to-static"

#include <iostream>
#include <vector>
#include <algorithm>
#include "helper.h"

using namespace std;
typedef vector<int> vi;


class Solution {
public:
    vector<vector<int>> subsets(vector<int> &nums) {
        vector<vector<int>> out;
        vector<int> empty;
        out.emplace_back(empty);

        for (auto &n: nums) {
            vector<vector<int>> copy = out;

            for (auto &arr: out) {
                arr.push_back(n);
            }

            for (auto &arr: copy) {
                out.emplace_back(arr);
            }
        }

        return out;
    }
};

int main() {
    vi v = {1, 2, 3};
    auto ans = Solution().subsets(v);

    return 0;
}