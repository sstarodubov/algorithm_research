from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        used = set()

        def backtrack(idx):
            if idx >= len(nums):
                key = "".join(map(lambda x: str(x), nums))
                if key not in used:
                    ans.append(nums[:])
                    used.add(key)
            else:
                for i in range(idx, len(nums)):
                    nums[i], nums[idx] = nums[idx], nums[i]
                    backtrack(idx + 1)
                    nums[i], nums[idx] = nums[idx], nums[i]

        backtrack(0)
        return ans


print(Solution().permuteUnique([1, 1, 2]))
print(Solution().permuteUnique([1, 2, 3]))
