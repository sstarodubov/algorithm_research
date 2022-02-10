from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True
        counter = 0
        if len(flowerbed) < 3:
            if n >= 2:
                return False
            if 1 in flowerbed:
                return False
            return True
        for i in range(1, len(flowerbed) - 1):
            prev = flowerbed[i - 1]
            cur = flowerbed[i]
            nxt = flowerbed[i + 1]

            if i == 1:
                if prev == 0 and cur == 0:
                    counter += 1
                    flowerbed[i - 1] = 1
                    prev = 1
            if i == len(flowerbed) - 2:
                if nxt == 0 and cur == 0:
                    counter += 1
                    flowerbed[i + 1] = 1
                    nxt = 1
            if prev == 0 and cur == 0 and nxt == 0:
                counter += 1
                flowerbed[i] = 1

        return counter >= n


assert not Solution().canPlaceFlowers([0, 0, 0, 0], 3)
assert Solution().canPlaceFlowers([0, 0, 1, 0, 0], 1)
assert Solution().canPlaceFlowers([0], 1)
assert Solution().canPlaceFlowers([1, 0, 0, 0, 1, 0, 0], 2)
assert Solution().canPlaceFlowers([0, 0, 1, 0, 1], 1)
assert Solution().canPlaceFlowers(flowerbed=[1, 0, 0, 0, 1], n=1)
assert not Solution().canPlaceFlowers(flowerbed=[1, 0, 0, 0, 1], n=2)
