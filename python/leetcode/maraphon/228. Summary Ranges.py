from typing import List


class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if not nums:
            return []
        ret, st = [], 0
        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] != 1:
                if st  == i - 1:
                    ret.append(str(nums[st]))
                else:
                    ret.append(f"{nums[st]}->{nums[i - 1]}")
                st = i

        if st == len(nums) - 1:
            ret.append(str(nums[st]))
        else:
            ret.append(f"{nums[st]}->{nums[-1]}")

        return ret


assert ["0", "2->4", "6", "8->9"] == Solution().summaryRanges([0, 2, 3, 4, 6, 8, 9])
assert ['0->2', '4->5', '7'] == Solution().summaryRanges([0, 1, 2, 4, 5, 7])
assert ['0->2', '4->6'] == Solution().summaryRanges([0, 1, 2, 4, 5, 6])
