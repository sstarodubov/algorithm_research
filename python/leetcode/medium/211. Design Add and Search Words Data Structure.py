class WordDictionary:

    def __init__(self):
        self.root = {"end": False}

    def addWord(self, word: str) -> None:
        node = self.root
        for w in word:
            if w not in node:
                node[w] = {"end": False}
            node = node[w]
        node["end"] = True

    def search(self, word: str) -> bool:
        self.ans = False

        def dfs(node, idx):
            if idx >= len(word):
                if node["end"]:
                    self.ans = True
                return
            if self.ans: return

            children = node.keys()

            for child in children:
                if child == "end": continue
                if child == word[idx] or word[idx] == ".":
                    dfs(node[child], idx + 1)

        dfs(self.root, 0)
        return self.ans


w = WordDictionary()
w.addWord("at")
w.addWord("and")
w.addWord("an")
w.addWord("add")

assert not w.search("a")
