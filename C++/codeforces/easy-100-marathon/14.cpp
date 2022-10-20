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

struct Node {
    unordered_map<char, Node*> children;
    bool is_end = false;
};

class Trie {
public:
    Node* root = new Node;

    void insert(const string& word) {
        Node* cur = root;

        for (char letter : word) {
            if (cur->children.find(letter) == cur->children.end()) {
                cur->children[letter] = new Node();
            }
            cur = cur->children[letter];
        }

        cur->is_end = true;
    }

    string prefix() {
        string ans;
        deque<Node*> dq;

        dq.emplace_back(root);
        Node* cur;
        while (!dq.empty()) {
            cur = dq.front();
            dq.pop_front();
            if (cur->children.size() != 1) return ans;
            if (cur->is_end) return ans;

            for (auto &[k,v] : cur->children) {
                ans += k;
                dq.emplace_back(v);
            }
        }
        return ans;
    }
};
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        Trie trie;
        for (auto & s : strs) {
            trie.insert(s);
        }

        return trie.prefix();
    }
};
int main() {
    vector<string> v = {"flower","flow","e"};
    auto a = Solution().longestCommonPrefix(v);
    cout << a;
    return 0;
}

