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
    vector<vector<int>> generate(int numRows) {
        if (numRows == 1) return {{1}};
        if (numRows == 2)
            return {{1},
                    {1, 1}};

        vector<vector<int>> tr = {{1},
                                  {1, 1}};

        for (int i = 2; i < numRows; i++) {
            vector<int> cur;
            cur.resize(i + 1 );
            cur[0] = 1;
            cur[i] = 1;

            for (int j = 1; j <= tr[i - 1].size() - 1; ++j) {
                cur[j] = tr[i- 1][j] + tr[i -1][j - 1];
            }

            tr.emplace_back(cur);
        }

        return tr;
    }
};


int main() {
    auto ans = Solution().generate(5);
    return 0;
}

