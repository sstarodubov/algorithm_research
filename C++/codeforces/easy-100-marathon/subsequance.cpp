#include <iostream>
#include <map>
#include <cmath>
#include <string>
#include <stack>
#include <vector>
#include <set>
#include <unordered_set>
#include <cstring>
#include "helper.h"

using namespace std;

class Solution {

public:
    bool isSubsequence(string s, string t) {
        int ps = 0;

        for (char &i: t) {
            if (i == s[ps]) ps++;
        }

        return s.size() == ps;
    }
};


int main() {
    auto ans = Solution().isSubsequence("abc", "ahbgdc");
    cout << ans;
    return 0;
}

