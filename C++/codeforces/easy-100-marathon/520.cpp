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
    bool detectCapitalUse(string word) {
        int k = 0;
        bool first = false;
        for (int i = 0; i < word.size(); ++i) {
            if (isupper(word[i])) {
                if (i == 0) first = true;
                k ++;
            }
        }

        return k == 0 || k == word.size() || (first && k == 1);
    }
};

int main() {
    cout << Solution().detectCapitalUse("USa");
    return 0;
}

