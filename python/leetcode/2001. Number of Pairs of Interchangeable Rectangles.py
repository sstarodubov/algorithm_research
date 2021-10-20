from typing import List


class Solution:

    # cpu O(n) and ram O(n)
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        table = {}
        for rect in rectangles:
            ratio = rect[0] / rect[1]
            if ratio in table:
                table[ratio] += 1
            else:
                table[ratio] = 1

        ans = 0
        for k in table:
            ans += int(((table[k] - 1) * table[k]) / 2)

        return ans


assert Solution().interchangeableRectangles(rectangles=[[4, 8], [3, 6], [10, 20], [15, 30]]) == 6
print("tests passed")
