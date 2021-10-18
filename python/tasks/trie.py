from typing import Dict


class TrieNode:

    def __init__(self, n: str, is_end: bool = False):
        self.name = n
        self.children: Dict[str, "TrieNode"] = {}
        self.end_of_word: bool = is_end

    def __str__(self):
        return f"name: {self.name}, children: {''.join(self.children.keys())} || isEnd: {self.end_of_word}"

    # cpu O(n)
    def insert(self, word: str):
        def _insert(w: str, cur_inx: int, cur_node: TrieNode):
            cur_letter = w[cur_inx]
            if cur_letter not in cur_node.children:
                if cur_inx != len(w) - 1:
                    new_node = TrieNode(cur_letter)
                    cur_node.children[cur_letter] = new_node
                    return _insert(w, cur_inx + 1, new_node)
                else:
                    new_node = TrieNode(cur_letter, True)
                    cur_node.children[cur_letter] = new_node
                    return new_node
            else:
                if cur_inx == len(w) - 1:
                    cur_node.children[cur_letter].end_of_word = True
                    return cur_node.children[cur_letter]
                else:
                    return _insert(w, cur_inx + 1, cur_node.children[cur_letter])

        _insert(word, 0, self)

    def prefix_contains(self, prefix: str) -> bool:
        if not prefix:
            return False
        cur_node = self
        for l in prefix:
            if l in cur_node.children:
                cur_node = cur_node.children[l]
            else:
                return False
        return True

    def word_contains(self, word: str) -> bool:
        cur_node = self
        for (idx, letter) in enumerate(word):
            if idx != len(word) - 1:
                if letter in cur_node.children:
                    cur_node = cur_node.children[letter]
                else:
                    return False
            else:
                if letter in cur_node.children and cur_node.children[letter].end_of_word:
                    return True
                return False

    def word_delete(self, word: str):
        cur_node = self
        for (idx, letter) in enumerate(word):
            if idx != len(word) - 1:
                if letter in cur_node.children:
                    cur_node = cur_node.children[letter]
                else:
                    return False
            else:
                if letter in cur_node.children and cur_node.children[letter].end_of_word:
                    cur_node.children[letter].end_of_word = False
                    return True
                return False


trie = TrieNode("root")
trie.insert("abc")
trie.insert("abgl")
trie.insert("cdf")
trie.insert("ab")
trie.insert("cdf")
trie.insert("abcd")
trie.insert("lmn")

# word delete
trie.insert("fff")
assert trie.word_contains("fff")
trie.word_delete("fff")
assert not trie.word_contains("fff")

# insert
assert trie.children["a"].children["b"].children["c"].end_of_word
assert trie.children["a"].children["b"].children["g"].children["l"].end_of_word
assert trie.children["c"].children["d"].children["f"].end_of_word
assert trie.children["a"].children["b"].end_of_word
assert trie.children["c"].children["d"].children["f"].end_of_word
assert trie.children["a"].children["b"].children["c"].children["d"].end_of_word
assert trie.children["l"].children["m"].children["n"].end_of_word

# word_contains
assert trie.word_contains("abc")
assert trie.word_contains("abgl")
assert trie.word_contains("lmn")
assert trie.word_contains("ab")
assert not trie.word_contains("cd")
assert not trie.word_contains("a")
assert not trie.word_contains("")
assert not trie.word_contains(" ")
assert not trie.word_contains("l")

# prefix_contains
assert trie.prefix_contains("ab")
assert trie.prefix_contains("c")
assert trie.prefix_contains("abcd")
assert trie.prefix_contains("lm")
assert not trie.prefix_contains("")
assert not trie.prefix_contains("dg")
