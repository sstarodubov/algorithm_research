from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        if len(nums) <= 2:
            return nums
        lx = [1] * (len(nums))
        rx = [1] * (len(nums))

        prev = 1
        for i in range(len(nums)):
            lx[i] = prev * nums[i]
            prev = lx[i]
        nxt = 1
        for i in range(len(nums) - 1, -1, -1):
            rx[i] = nxt * nums[i]
            nxt = rx[i]

        for i in range(len(nums)):
            if i == 0:
                nums[0] = rx[1]
            elif i == len(nums) - 1:
                nums[-1] = lx[-2]
            else:
                nums[i] = lx[i - 1] * rx[i + 1]

        return nums


assert Solution().productExceptSelf([1, 2, 3, 4]) == [24, 12, 8, 6]
assert Solution().productExceptSelf([-1, 1, 0, -3, 3]) == [0, 0, 9, 0, 0]
