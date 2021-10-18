from collections import defaultdict
from typing import List


class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        left = 0
        c = defaultdict(int)
        result = 0
        for right in range(len(fruits)):
            c[fruits[right]] += 1
            while len(c) > 2:
                c[fruits[left]] -= 1
                if c[fruits[left]] == 0:
                    del c[fruits[left]]
                left += 1
            result = max(result, right - left + 1)

        return result


s = Solution()

assert s.totalFruit([0, 1, 2, 2]) == 3
assert s.totalFruit(fruits=[1, 2, 1]) == 3
print("test passed")
