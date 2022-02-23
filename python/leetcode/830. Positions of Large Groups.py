from typing import List


class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        lt, rt = 0, 0
        ans = []
        while rt < len(s):
            if s[lt] == s[rt]:
                rt += 1
            else:
                if rt - lt >= 3:
                    ans.append([lt, rt - 1])
                lt = rt
        if rt - lt >= 3:
            ans.append([lt, rt - 1])
        return ans


assert Solution().largeGroupPositions("aaa") == [[0, 2]]
assert Solution().largeGroupPositions("abcdddeeeeaabbbcd") == [[3, 5], [6, 9], [12, 14]]
assert Solution().largeGroupPositions("abc") == []
assert Solution().largeGroupPositions("abbxxxxzzy") == [[3, 6]]
