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
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int> m;
        for (int i = 0; i < ransomNote.size(); ++i) {
            m[ransomNote[i]] += 1;
        }

        for (int i = 0; i < magazine.size(); ++i) {
            m[magazine[i]] -= 1;
        }

        for (int i = 0; i < ransomNote.size(); ++i) {
            if (m[ransomNote[i]] >= 1) return false;
        }

        return true;
    }
};


int main() {
    cout << Solution().canConstruct("aa", "baa");
    return 0;
}

