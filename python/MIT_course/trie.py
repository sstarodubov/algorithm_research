class Trie:

    def default_dict(self):
        return {"end": False}

    def __init__(self):
        self.root = self.default_dict()

    def insert(self, word: str) -> None:
        cur = self.root
        for letter in word:
            if letter not in cur:
                cur[letter] = self.default_dict()

            cur = cur[letter]
        cur["end"] = True

    def exists(self, word: str) -> bool:
        cur = self.root
        for letter in word:
            if letter not in cur:
                return False
            cur = cur[letter]
        return cur["end"]


trie = Trie()
trie.insert("app")
trie.insert("apps")
trie.insert("banana")
trie.insert("ban")

assert trie.exists("app")
assert trie.exists("apps")
assert trie.exists("banana")
assert trie.exists("ban")
assert not trie.exists("ba")
assert not trie.exists("ap")
assert not trie.exists("appps")

print("tests passed")
