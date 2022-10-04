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
    void reverseString(vector<char> &s) {
        int l = 0, r = s.size() - 1;
        char t;
        while (l < r) {
            t = s[l];
            s[l] = s[r];
            s[r] = t;
            r--;
            l++;
        }
    }
};


int main() {
    vector<char> v = {'h', 'e', 'l', 'l', 'o'};
    Solution().reverseString(v);
    for(auto& c : v) {
        cout << c;
    }
    return 0;
}

