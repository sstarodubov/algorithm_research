from typing import List


class Solution:

    # cpu O(n) and ram O(n)
    def replaceElements(self, arr: List[int]) -> List[int]:
        result = [-1]
        cur_max = - 1
        for n in reversed(arr):
            cur_max = max(cur_max, n)
            result.append(cur_max)
        result.pop()
        result.reverse()
        return result


s = Solution()

assert s.replaceElements([17, 18, 5, 4, 6, 1]) == [18, 6, 6, 6, 1, -1], 1
assert s.replaceElements([400]) == [-1], 0
print("tests passed")
