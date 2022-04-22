from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        sm = sum(nums)
        lp, rp = 0, len(nums) - 1
        while nums[lp] != nums[rp]:
            if (sm - nums[lp]) & 1 == 0:
                lp += 1
                sm -= nums[lp]
            else:
                rp -= 1
                sm -= nums[rp]

        return nums[lp]


assert 2 == Solution().findDuplicate([2, 2, 2, 2, 2])
assert 2 == Solution().findDuplicate([1, 3, 4, 2, 2])
