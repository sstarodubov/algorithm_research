from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        ptr = len(digits) - 1
        while ptr >= 0:
            if carry:
                n = digits[ptr] + 1
                if n >= 10:
                    digits[ptr] = 0
                else:
                    carry -= 1
                    digits[ptr] = n
            else:
                break
            ptr -= 1
        if carry:
            digits.insert(0, 1)
        return digits


assert [1, 0] == Solution().plusOne([9])
assert [4, 3, 2, 2] == Solution().plusOne([4, 3, 2, 1])
assert [1, 2, 4] == Solution().plusOne([1, 2, 3])
