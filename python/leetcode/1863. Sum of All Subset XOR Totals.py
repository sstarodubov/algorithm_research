from typing import List


class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        def xor(arr: List[int]) -> int:
            if not arr:
                return 0
            if len(arr) == 1:
                return arr[0]
            result = 0
            for a in arr:
                result ^= a
            return result

        sets = [[]]
        for i in range(len(nums)):
            tmp = []
            for s in sets:
                tmp.append(s[:])
                s.append(nums[i])
            for t in tmp:
                sets.append(t)
        ans = 0
        for s in sets:
            ans += xor(s)
        return ans


assert Solution().subsetXORSum([5, 1, 6]) == 28
