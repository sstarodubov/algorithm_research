from typing import List


class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        l, r = 0, 1
        cur_sum = nums[0]
        while r < len(nums):
            if nums[r - 1]  + 1 == nums[r]:
                cur_sum += nums[r]
            else:
                break
            r += 1

        if r == len(nums):
            return cur_sum + 1

        ret = cur_sum
        container = set(nums)
        while ret in container:
            ret += 1

        return ret


print(Solution().missingInteger([100]))

