from typing import List


class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        sor = sorted(nums, reverse=True)
        ptr = 0
        mp = {}
        while ptr < len(nums) - 1:
            while ptr < len(nums) - 1 and sor[ptr] == sor[ptr + 1]:
                ptr += 1
            mp[sor[ptr]] = len(nums) - ptr - 1
            ptr += 1

        mp[sor[-1]] = 0
        ans = []
        for n in nums:
            ans.append(mp[n])
        return ans


assert [0, 0, 0, 0] == Solution().smallerNumbersThanCurrent([7, 7, 7, 7])
assert [4, 0, 1, 1, 3] == Solution().smallerNumbersThanCurrent([8, 1, 2, 2, 3])
