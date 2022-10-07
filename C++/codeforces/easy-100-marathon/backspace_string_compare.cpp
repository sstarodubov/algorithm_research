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
    bool backspaceCompare(string s, string t) {
        stack<char> ss;
        stack<char> st;

        for (int i = 0; i < s.size(); ++i) {
            if (ss.empty()) {
                if (s[i] != '#') ss.push(s[i]);
            } else {
                if (s[i] == '#') {
                    ss.pop();
                } else {
                    ss.push(s[i]);
                }
            }
        }

        for (int i = 0; i < t.size(); ++i) {
            if (st.empty()) {
                if (t[i] != '#') st.push(t[i]);
            }
            else {
                if (t[i] == '#') {
                    st.pop();
                } else {
                    st.push(t[i]);
                }
            }
        }


        if (ss.size() != st.size()) return false;

        while (!st.empty()) {
            if (st.top() != ss.top()) return false;

            st.pop();
            ss.pop();
        }


        return true;
    }
};

int main() {
    string s = "ab#c";
    string t = "ad#c";
    cout << Solution().backspaceCompare(s, t);
    return 0;
}

