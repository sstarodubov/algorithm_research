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
    unordered_map<int, unordered_map<int, int>> dp;

    int uniquePaths(int m, int n) {
        return dfs(n, m, m, n);
    }

    int dfs(int x, int y, int m, int n) {
        if (dp[x][y] != 0) return dp[x][y];
        if (x > n || x <= 0) return 0;
        if (y > m || y <= 0) return 0;
        if (x == 1 && y == 1) return 1;

        dp[x][y] =dfs(x - 1, y, m, n) + dfs(x, y - 1, m, n);
        return dp[x][y];
    }
};

int main() {
    cout << Solution().uniquePaths(3, 7);
    return 0;
}

