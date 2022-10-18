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
    bool isValid(string s) {
        stack<char> stack;

        for (int i = 0; i < s.size(); ++i) {
            if (stack.empty()) {
                stack.push(s[i]);
            } else {

                char top = stack.top();

                if (top == '(' && s[i] == ')') {
                    stack.pop();
                } else if (top == '[' && s[i] == ']') {
                    stack.pop();
                } else if (top == '{' && s[i] == '}') {
                    stack.pop();
                } else {
                    stack.push(s[i]);
                }
            }
        }

        return stack.empty();
    }
};

int main() {
    auto a = Solution().isValid("{[]}");
    cout << a;
    return 0;
}

