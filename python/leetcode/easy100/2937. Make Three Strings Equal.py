class Trie:
    def __init__(self):
        self.root = {"end": False}

    def add(self, word):
        cur = self.root
        for ch in word:
            if ch not in cur:
                cur[ch] = {"end": False}
            cur = cur[ch]
        cur["end"] = True

    def prefix_size(self):
        self.result = -1
        self.found = False

        def dfs(node, depth = 0):
            if not node or self.found:
                return
            if len(node) <= 2 and node["end"] == False:
                for child in node:
                    if child == "end":
                        continue
                    dfs(node[child], depth + 1)
            else:
                self.result = depth
                self.found = True

        dfs(self.root)
        return -1 if self.result == 0 else self.result


class Solution:
    def findMinimumOperations(self, s1: str, s2: str, s3: str) -> int:
        if s1 == s2 == s3:
            return 0
        trie: Trie = Trie()
        trie.add(s1)
        trie.add(s2)
        trie.add(s3)
        common_len = trie.prefix_size()
        if common_len == -1:
            return -1
        ans = 0
        ans += len(s1) - common_len
        ans += len(s2) - common_len
        ans += len(s3) - common_len
        return ans

assert 3 == Solution().findMinimumOperations("a", "a", "aabc")
assert -1 == Solution().findMinimumOperations(s1 = "dac", s2 = "bac", s3 = "cac")
assert 2 == Solution().findMinimumOperations(s1="abc", s2="abb", s3="ab")
