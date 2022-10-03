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
    int singleNumber(vector<int>& nums) {
        int ans = 0;
        for(auto & n : nums) {
            ans ^= n;
        }

        return ans;
    }
};


int main() {
    vi v = {4,1,2,1,2};
    cout << Solution().singleNumber(v) << endl;
    return 0;
}

