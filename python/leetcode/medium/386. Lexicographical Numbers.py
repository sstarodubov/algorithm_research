from typing import List


class Trie:
    def __init__(self):
        self.root = {"$": False}

    def add(self, word):
        cur = self.root
        for ch in word:
            if ch not in cur:
                cur[ch] = {"$": False}
            cur = cur[ch]
        cur["$"] = True


class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        trie = Trie()

        for i in range(1, n + 1):
            trie.add(str(i))
        ans = []

        def dfs(node, cur):
            if node["$"]:
                ans.append(cur)
            if len(node) == 1:
                return
            children = node.keys()

            for child in children:
                if child == "$": continue
                dfs(node[child], cur + child)

        dfs(trie.root, "")

        return list(map(lambda x: int(x), ans))


assert Solution().lexicalOrder(13) == [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
