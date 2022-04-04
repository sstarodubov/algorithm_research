class Trie:
    def __init__(self):
        self.root = {"end": False, "idx": -1}

    def insert(self, word: str, idx: int):
        cur = self.root
        for ch in word:
            if ch not in cur:
                cur[ch] = {"end": False, "idx": idx}
            cur = cur[ch]
        cur["end"] = True

    def exists(self, word: str):
        cur = self.root
        for ch in word:
            if ch not in cur:
                return -1
            cur = cur[ch]
        return cur["idx"]


class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split(" ")
        trie = Trie()
        idx = 1
        for word in words:
            trie.insert(word, idx)
            idx += 1

        return trie.exists(searchWord)


assert Solution().isPrefixOfWord(sentence="i love eating burger", searchWord="burg") == 4
