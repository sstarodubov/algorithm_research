from typing import List


class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        ans = [""] * len(s)

        for i in range(len(s)):
            ans[indices[i]] = s[i]
        return "".join(ans)


assert Solution().restoreString("codeleet", [4, 5, 6, 7, 0, 2, 1, 3])
