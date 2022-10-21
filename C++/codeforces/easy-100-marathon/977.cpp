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
    vector<int> sortedSquares(vector<int>& nums) {
        std::sort(nums.begin(), nums.end(), [](const int &a, const int &b){
            return pow(a, 2) < pow(b, 2) ;
        });

        for (int i = 0; i < nums.size(); ++i) {
            nums[i] *= nums[i];
        }
        return nums;
    }
};

int main() {

    return 0;
}

