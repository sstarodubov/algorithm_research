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
    int firstUniqChar(string s) {
        unordered_map<char, int> m ;

        for (int i = 0; i < s.size(); ++i) {
            m[s[i]] += 1;
        }

        for (int i = 0; i < s.size(); ++i) {
            if (m[s[i]] == 1) return i;
        }

        return -1;
    }
};

int main() {
    cout << Solution().firstUniqChar("loveleetcode");
    return 0;
}

