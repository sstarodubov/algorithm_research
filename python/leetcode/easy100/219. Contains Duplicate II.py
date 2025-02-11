from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        win = set()

        for i in range(k + 1):
            if i >= len(nums):
                return False
            if nums[i] in win:
                return True
            win.add(nums[i])

        if len(win) != k + 1:
            return True

        for i in range(k + 1,  len(nums)):
            win.remove(nums[i - k - 1])
            win.add(nums[i])
            if len(win) != k + 1:
                return True

        return False
print(Solution().containsNearbyDuplicate([1], 1))
print(Solution().containsNearbyDuplicate([1,2,3,1,2,3], 2))


