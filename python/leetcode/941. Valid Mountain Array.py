from typing import List


class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        idx, mx = 0, float("-inf")
        for i in range(len(arr)):
            if arr[i] >= mx:
                idx = i
                mx = arr[i]
        if arr[idx] == arr[0] or arr[idx] == arr[len(arr) - 1]:
            return False

        for i in range(1, idx):
            if arr[i] <= arr[i - 1]:
                return False

        for i in range(idx + 1, len(arr) - 1):
            if arr[i + 1] >= arr[i]:
                return False

        return True


assert not Solution().validMountainArray([3, 5, 5])
assert Solution().validMountainArray([0, 3, 2, 1])
