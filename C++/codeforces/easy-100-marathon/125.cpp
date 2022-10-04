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
    bool isPalindrome(string s) {

        string s2;


        for (int i = 0; i < s.size(); ++i) {
            if (isalnum(s[i])) {
                s2+=tolower(s[i]);
            }
        }

        if (s2.empty()) return true;

        int l = 0, r = s2.size() - 1;


        while (l < r) {
            if (s2[l] != s2[r]) return false;
            l++;
            r--;
        }

        return true;
    }
};


int main() {
    string s = "A man, a plan, a canal: Panama";
    cout << Solution().isPalindrome(s) << endl;
    return 0;
}

