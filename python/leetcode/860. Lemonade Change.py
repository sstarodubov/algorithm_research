from typing import List


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        w = {5: 0, 10: 0, 20: 0}
        for idx, b in enumerate(bills):
            if b == 10:
                if w[5] == 0:
                    return False
                w[5] -= 1
                w[10] += 1
            elif b == 20:
                if w[5] == 0:
                    return False
                if w[5] >= 1 and w[10] >= 1:
                    w[5] -= 1
                    w[10] -= 1
                elif w[5] >= 3:
                    w[5] -= 3
                else:
                    return False
                w[20] += 1
            elif b == 5:
                w[5] += 1
        return True


assert not Solution().lemonadeChange([5, 5, 5, 5, 20, 20, 5, 5, 20, 5])
assert not Solution().lemonadeChange([5, 5, 5, 10, 5, 5, 10, 20, 20, 20])
assert Solution().lemonadeChange([5, 5, 5, 10, 20])
assert not Solution().lemonadeChange([5, 5, 10, 10, 20])
