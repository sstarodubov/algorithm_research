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
    string reverseWords(string s) {

        auto b = s.begin();

        for (auto it = s.begin(); it != s.end(); it++) {
            if (*it == ' ') {
                reverse(b, it);
                b = it + 1;
            }
        }

        reverse(b, s.end());

        return s;
    }
};

int main() {
    string s = "Let's take LeetCode contest";
    cout << Solution().reverseWords(s);
    return 0;
}

