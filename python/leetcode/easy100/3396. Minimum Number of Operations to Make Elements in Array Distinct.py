from typing import List


class Solution:

    def minimumOperations(self, nums: List[int]) -> int:
        xs = set()
        idx = -1
        for i in range(len(nums) - 1, -1, -1):
            el = nums[i]
            if el in xs:
                idx = i
                break
            xs.add(el)

        if idx == -1:
            return 0
        idx += 1
        mode = (idx) % 3
        diff = 0 if mode == 0 else 3 - mode
        return (idx + (diff)) // 3


assert 2 == Solution().minimumOperations([1, 2, 3, 4, 2, 3, 3, 5, 7])
assert 2 == Solution().minimumOperations([4, 5, 6, 4, 4])
