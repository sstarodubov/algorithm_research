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
    int numJewelsInStones(string jewels, string stones) {
        unordered_set<char> jset;

        for (int j = 0; j < jewels.size(); ++j) {
            jset.insert(jewels[j]);
        }
        int ans = 0;
        for (int i = 0; i < stones.size(); ++i) {
            if (jset.find(stones[i]) != jset.end()) {
                ans ++;
            }
        }

        return ans;
    }
};

int main() {

    return 0;
}

