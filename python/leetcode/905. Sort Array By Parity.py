from typing import List


class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        lft, rgt = 0, len(nums) - 1
        nums.sort()
        while lft < rgt:
            if nums[lft] & 1 == 0 and nums[rgt] & 1 == 0:
                lft += 1
                continue
            elif nums[lft] & 1 == 1 and nums[rgt] & 1 == 0:
                nums[lft], nums[rgt] = nums[rgt], nums[lft]
                lft += 1
                rgt -= 1
            elif nums[lft] & 1 == 1 and nums[rgt] & 1 == 1:
                rgt -= 1
            else:
                lft += 1
                rgt -= 1
        return nums


Solution().sortArrayByParity([0, 2, 1, 3, 5])
Solution().sortArrayByParity([0, 2, 1])
Solution().sortArrayByParity([3, 1, 2, 4])
