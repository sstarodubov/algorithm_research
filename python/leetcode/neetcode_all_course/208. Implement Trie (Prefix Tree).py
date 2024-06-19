class Trie:

    def newNode(self) -> {}:
        return {"$": False}

    def __init__(self):
        self.root = self.newNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for ch in word:
            if ch not in cur:
                cur[ch] = self.newNode()
            cur = cur[ch]

        cur["$"] = True

    def search(self, word: str) -> bool:
        cur = self.root
        for ch in word:
            if ch not in cur:
                return False
            cur = cur[ch]

        return cur["$"]

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for ch in prefix:
            if ch not in cur:
                return False
            cur = cur[ch]

        return True


trie = Trie()
trie.insert("aaab")
trie.insert("aa")

print(trie.startsWith("a"))
print(trie.search("aa"))