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

using namespace std;

typedef vector<int> vi;

class Solution {
public:
    string reverseVowels(string s) {
        if (s.empty()) return "";
        unordered_set<char> v = {'a', 'e', 'i', 'o', 'u'};
        int l = 0, r = s.size() - 1;
        char t;
        while (l < r) {
            while (l < r && v.find(tolower(s[l])) == v.end()) l++;
            while (r > l && v.find(tolower(s[r])) == v.end()) r--;
            if (l >= r) return s;
            t = s[l];
            s[l] = s[r];
            s[r] = t;
            r--;
            l++;
        }

        return s;
    }
};

int main() {

    string s = "aA";
    cout << Solution().reverseVowels(s);

    return 0;
}

