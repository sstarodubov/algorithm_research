from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int, exl_idx: int, ans):
        lp, rp = exl_idx + 1, len(nums) - 1
        while lp < rp:
            if lp >= rp:
                return
            cs = nums[lp] + nums[rp]
            if cs == target:
                ans.append([nums[lp], nums[rp], nums[exl_idx]])
            if cs < target:
                lp += 1
                while lp > 0 and lp < len(nums) and nums[lp - 1] == nums[lp]:
                    lp += 1
            else:
                rp -= 1
                while rp <= len(nums) - 2 and rp >= 0 and nums[rp + 1] == nums[rp]:
                    rp -= 1


    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if len(nums) <= 2:
            return []
        nums.sort()
        ans = []
        used = set()
        for i in range(len(nums)):
            if nums[i] in used:
                continue
            self.twoSum(nums, -nums[i], i, ans)
            used.add(nums[i])

        return ans


assert Solution().threeSum([1, 2, -2, -1]) == []
assert Solution().threeSum([0, 0, 0, 0]) == [[0, 0, 0]]
assert Solution().threeSum([-1, 0, 1, 2, -1, -4]) == [[-1, -1, 2], [-1, 0, 1]]
