from typing import List


class Solution:

    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if abs(nums[i] - nums[j]) <= t and abs(i - j) <= k:
                    return True
        return False


s = Solution()

assert s.containsNearbyAlmostDuplicate([1, 2, 3, 1], k=3, t=0)
assert s.containsNearbyAlmostDuplicate([1, 0, 1, 1], k=1, t=2)
assert not s.containsNearbyAlmostDuplicate([1, 5, 9, 1, 5, 9], k=2, t=3)

print("tests passed")
