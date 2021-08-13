from typing import List


class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        m = float("-inf")
        ans = 0
        for i in range(len(arr)):
            if m < arr[i]:
                m = arr[i]
                ans = i
        return ans

s = Solution()

assert 1 == s.peakIndexInMountainArray(arr=[0, 1, 0]), 0
assert 1 == s.peakIndexInMountainArray(arr=[0, 2, 1, 0]), 1

print("tests passed")
