from typing import List


class Solution:

    #time O(n ^2), space O(1)
    def longestCommonPrefix(self, strs: List[str]) -> str:
        ptr = 0
        while True:
            for i in range(len(strs)):
                if ptr >= len(strs[i]):
                    return strs[i][:ptr]

                if i == 0:
                    cur = strs[i][ptr]
                else:
                    if cur != strs[i][ptr]:
                        return strs[i][:ptr]
            ptr += 1


assert "" == Solution().longestCommonPrefix(["dog", "racecar", "car"])
assert "fl" == Solution().longestCommonPrefix(["flower", "flow", "flight"])
