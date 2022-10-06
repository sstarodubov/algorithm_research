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
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;

        unordered_map<char, int> map;

        for(auto& ch : s) {
            map[ch] += 1;
        }

        for(auto & ch : t) {
            if (map.find(ch) == map.end()) {
                return false;
            }

            map[ch] -= 1;
        }

        for (auto & it : map) {
            if (it.second != 0) return false;
        }

        return true;
    }
};

int main() {
    string s = "helle";
    string t = "hlloe";
    cout << Solution().isAnagram(s, t);
    return 0;
}

