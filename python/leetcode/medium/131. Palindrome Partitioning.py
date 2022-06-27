from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans, cur = [], []

        def is_p(s, i, j):
            if i == j:
                return True
            while j >= 0 and i < len(s) and i <= j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1

            return True

        def backtrack(i):
            if i >= len(s):
                ans.append(cur[:])
            else:
                for j in range(i, len(s)):
                    if is_p(s, i, j):
                        cur.append(s[i:j + 1])
                        backtrack(j + 1)
                        cur.pop()

        backtrack(0)


        return ans


assert Solution().partition("aab") == [["a", "a", "b"], ["aa", "b"]]
