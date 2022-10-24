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
    vector<string> fizzBuzz(int n) {
        vector<string> ans;

        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.emplace_back("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.emplace_back("Fizz");
            } else if (i % 5 == 0) {
                ans.emplace_back("Buzz");
            } else {
                ans.emplace_back(to_string(i));
            }
        }

        return ans;
    }
};

int main() {
    auto  ans = Solution().fizzBuzz("aa", "baa");
    return 0;
}

