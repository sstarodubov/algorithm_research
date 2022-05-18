class Trie:

    def __init__(self):
        self.root = {"end": False}

    def insert(self, word: str) -> None:
        node = self.root
        for w in word:
            if w not in node:
                node[w] = {"end": False}
            node = node[w]
        node["end"] = True

    def search(self, word: str) -> bool:
        node = self.root
        for w in word:
            if w not in node:
                return False
            node = node[w]
        return node["end"] == True

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for w in prefix:
            if w not in node:
                return False
            node = node[w]
        return True
