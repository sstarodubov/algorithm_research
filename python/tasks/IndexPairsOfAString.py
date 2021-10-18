from trie import TrieNode


class Solution:

    def index_pairs(self, text: str, words: [str]) -> [[str]]:
        ans = []
        trie = TrieNode("root")
        for w in words:
            trie.insert(w)
        for i in range(len(text)):
            for y in range(i, len(text)):
                if trie.word_contains(text[i:y + 1]):
                    ans.append([i, i + len(text[i:y + 1]) - 1])
        return ans


s = Solution()

assert s.index_pairs(text="thestoryofleetcodeandme", words=["story", "fleet", "leetcode"]) == [[3, 7], [9, 13],
                                                                                               [10, 17]]
assert s.index_pairs(text="ababa", words=["aba", "ab"]) == [[0, 1], [0, 2], [2, 3], [2, 4]]

print("tests passed")
