from typing import List, Set


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = set()
        result = []
        nums.sort()
        nums = list(map(str, nums))
        self.backtrack(nums, 0, ans, result)
        return result

    def backtrack(self, nums: List[int], idx: int, table: Set[int], result):
        if idx >= len(nums):
            key: str = "".join(nums[:])
            if key not in table:
                result.append(list(map(int, nums[:])))
                table.add(key)
        else:
            for i in range(idx, len(nums)):
                if idx != i and nums[i] == nums[idx]:
                    continue
                nums[idx], nums[i] = nums[i], nums[idx]
                self.backtrack(nums, idx + 1, table, result)
                nums[i], nums[idx] = nums[idx], nums[i]


assert Solution().permuteUnique([2, 2, 1, 1]) == [[1, 1, 2, 2], [1, 2, 1, 2], [1, 2, 2, 1], [2, 1, 1, 2], [2, 1, 2, 1],
                                                  [2, 2, 1, 1]]
assert Solution().permuteUnique([1, 1, 1]) == [[1, 1, 1]]
assert Solution().permuteUnique([1, 2, 3]) == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
assert Solution().permuteUnique([1, 1, 2]) == [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
print("tests passed")
