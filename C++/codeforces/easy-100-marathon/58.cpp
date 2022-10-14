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
    int lengthOfLastWord(string s) {
        int k = s.size() - 1;

        while (s[k] == ' ') {
            k --;
        }

        for (int i = k; i >= 0 ; --i) {
            if (s[i] == ' ') {
                return k - i;
            }
        }

        return k + 1;
    }
};

int main() {
    cout << Solution().lengthOfLastWord("day    ");

    return 0;
}

