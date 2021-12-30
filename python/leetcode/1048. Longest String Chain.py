from typing import List, Set, Dict


class Solution:

    # time O(n^2), space O(n)
    def longestStrChain(self, words: List[str]) -> int:
        if not words:
            return 0

        self.ans = 1
        words.sort(key=lambda x: len(x))
        graph = {}
        for hptr in range(len(words)):
            graph[words[hptr]] = []
            bptr = hptr - 1
            while bptr >= 0 and len(words[bptr]) + 1 >= len(words[hptr]):
                if self.is_pred(words[bptr], words[hptr]):
                    graph[words[bptr]].append(words[hptr])
                bptr -= 1
        visited = set([])

        for node in graph.keys():
            self.dfs(graph, node, visited, 0)

        return self.ans

    def dfs(self, graph: Dict, cur_node: str, visited: Set, count):
        if cur_node in visited:
            return
        visited.add(cur_node)
        children = graph[cur_node]
        count += 1
        for child in children:
            self.dfs(graph, child, visited, count)
        self.ans = max(self.ans, count)

    def is_pred(self, s1, s2) -> bool:
        if len(s1) + 1 != len(s2):
            return False
        ptr = 0

        for i in range(len(s2)):
            if ptr >= len(s1):
                return True
            if s1[ptr] == s2[i]:
                ptr += 1

        return ptr == len(s1)


assert Solution().longestStrChain(
    ["ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq",
     "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"]) == 7
assert Solution().longestStrChain(["xbc", "pcxbcf", "xb", "cxbc", "pcxbc"]) == 5
assert Solution().longestStrChain(["a", "b", "ba", "bca", "bda", "bdca"]) == 4
assert Solution().longestStrChain(["abcd", "dbqca"]) == 1
print("tests passed")
