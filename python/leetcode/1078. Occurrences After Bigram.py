from typing import List


class Solution:
    #time O(n), space O(n)
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        arr = text.split(" ")
        ans = []

        for i in range(2, len(arr)):
            fs = arr[i - 2]
            ss = arr[i - 1]
            ts = arr[i]
            if fs == first and ss == second:
                ans.append(ts)

        return ans


assert Solution().findOcurrences(text="alice is a good girl she is a good student", first="a", second="good") == [
    "girl", "student"]
