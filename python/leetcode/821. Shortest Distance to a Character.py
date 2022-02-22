from typing import List


class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        arr = [float("inf")] * len(s)
        for i in range(len(s)):
            if s[i] == c:
                arr[i] = 0

        for i in range(len(s)):
            if arr[i] != 0:
                continue

            left, right = i - 1, i + 1
            lc, rc = 1, 1

            while left >= 0 and s[left] != c:
                arr[left] = min(arr[left], lc)
                lc += 1
                left -= 1

            while right < len(s) and s[right] != c:
                arr[right] = min(arr[right], rc)
                rc += 1
                right += 1

        return arr


assert Solution().shortestToChar(s="loveleetcode", c="e") == [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
