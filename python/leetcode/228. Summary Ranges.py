from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if not nums:
            return []
        f, b = 0, 0
        c = nums[f]
        nums.append(-1)
        ans = []
        while f + 1 < len(nums):
            if nums[f + 1] == nums[f] + 1:
                f += 1
            else:
                if b == f:
                    ans.append(str(nums[b]))
                else:
                    ans.append(f"{nums[b]}->{nums[f]}")
                b = f
                f += 1
                b += 1
        return ans


assert Solution().summaryRanges([0, 1, 2, 4, 5, 7]) == ["0->2", "4->5", "7"]
assert Solution().summaryRanges([0, 2, 3, 4, 6, 8, 9]) == ["0", "2->4", "6", "8->9"]
