from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans = [-1, -1]
        lp ,rp = 0 , len(nums) - 1

        while lp <= rp:
            mp = (lp + rp) // 2
            if nums[mp] == target and (mp - 1 < 0 or nums[mp - 1] != target):
                ans[0] = mp
                break
            elif nums[mp] >= target:
                rp = mp - 1
            elif nums[mp] < target:
                lp = mp + 1

        lp, rp = 0, len(nums) - 1

        while lp <= rp:
            mp = (lp + rp) // 2
            if nums[mp] == target and (mp + 1 >= len(nums) or nums[mp + 1] != target):
                ans[1] = mp
                break
            elif nums[mp] <= target:
                lp = mp + 1
            elif nums[mp] > target:
                rp = mp - 1

        if -1 in ans:
            return [max(ans), max(ans)]

        return ans



assert Solution().searchRange(nums=[5, 7, 7, 8, 8, 10], target=8) == [3, 4]
