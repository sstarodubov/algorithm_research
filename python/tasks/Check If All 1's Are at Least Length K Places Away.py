from typing import List


class Solution:

    # cpu O(n) , ram in place
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        f = 0
        while nums[f] != 1:
            f += 1
            if f >= len(nums):
                return True
        s = f + 1
        while s < len(nums):
            if nums[s] == 1:
                d = s - f
                if d <= k:
                    return False
                f = s
                s += 1
            else:
                s += 1

        return True


assert not Solution().kLengthApart([0, 0, 0], 2)
assert Solution().kLengthApart(nums=[1, 0, 0, 0, 1, 0, 0, 1], k=2)
assert not Solution().kLengthApart([1, 0, 0, 1, 0, 1], k=2)
assert Solution().kLengthApart([1, 1, 1, 1, 1], k=0)
assert Solution().kLengthApart([0, 1, 0, 1], k=1)
print("tests passed")
