from typing import List


class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        res = []
        fp = 0
        sp = n
        while True:
            if sp >= len(nums):
                return res
            res.append(nums[fp])
            res.append(nums[sp])
            fp += 1
            sp += 1


s = Solution()

assert s.shuffle([2, 5, 1, 3, 4, 7], n=3) == [2, 3, 5, 4, 1, 7]

print("tests passed")
