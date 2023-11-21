from typing import List


class Solution:
    def is_pal(self, s: str) -> bool:
        if len(s) == 0:
            return True
        lt, rt = 0, len(s) - 1
        while lt < rt:
            if s[lt] != s[rt]:
                return False
            lt += 1
            rt -= 1
        return True

    def partition(self, s: str) -> List[List[str]]:
        self.ret = []

        def backtrack(st, comb=[]):
            if not st:
                self.ret.append(comb[:])
            else:
                for i in range(len(st)):
                    head = st[:i + 1]
                    tail = st[i + 1:]
                    if self.is_pal(head):
                        comb.append(head)
                        backtrack(tail, comb)
                        comb.pop()

        backtrack(s)
        return self.ret


assert [["a", "a", "b"], ["aa", "b"]] == Solution().partition("aab")
assert [["a"]] == Solution().partition("a")
