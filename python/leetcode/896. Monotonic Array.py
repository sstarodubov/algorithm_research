from typing import List


class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        def down(arr: List[int]) -> bool:
            for i in range(1, len(arr)):
                if arr[i - 1] > arr[i]:
                    return False
            return True

        def up(arr: List[int]) -> bool:
            for i in range(1, len(arr)):
                if arr[i - 1] < arr[i]:
                    return False
            return True

        return down(nums) or up(nums)


assert Solution().isMonotonic([1, 2, 2, 3])
assert Solution().isMonotonic([6, 5, 4, 4])
assert not Solution().isMonotonic([1, 3, 2])
