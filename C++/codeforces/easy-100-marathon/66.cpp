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
#include "helper.h"

using namespace std;

class Solution {

public:
    vector<int> plusOne(vector<int> &digits) {
        size_t L = digits.size();
        for (size_t i = L; i-- > 0;) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        digits.insert(digits.begin(), 1);
        return digits;
    }
};


int main() {
    vector<int> v = {9, 9, 9};
    auto r = Solution().plusOne(v);
    return 0;
}

