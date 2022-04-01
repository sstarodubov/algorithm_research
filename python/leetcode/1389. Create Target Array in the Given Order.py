from typing import List


class Solution:
    def createTargetArray(self, nums: List[int], index: List[int]) -> List[int]:
        ans = []
        for i in range(len(nums)):
            ans.insert(index[i], nums[i])
        return ans


assert Solution().createTargetArray(nums=[0, 1, 2, 3, 4], index=[0, 1, 2, 2, 1]) == [0, 4, 1, 3, 2]
