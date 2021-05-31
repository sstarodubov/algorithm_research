from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for i in range(0, len(asteroids)):
            el = asteroids[i]
            if len(stack) == 0:
                stack.append(el)
            else:
                stack.append(el)
                pre = stack[len(stack) - 2]
                last = stack[len(stack) - 1]
                while len(stack) >= 2 and pre > 0 and last < 0:
                    if abs(last) == abs(pre):
                        stack.pop()
                        stack.pop()
                    elif abs(pre) > abs(last):
                        stack.pop()
                    elif abs(last) > abs(pre):
                        stack.pop()
                        stack.pop()
                        stack.append(last)
                    if len(stack) >= 2:
                        pre = stack[len(stack) - 2]
                        last = stack[len(stack) - 1]
        return stack


s = Solution()

assert [] == s.asteroidCollision([8, -8]), 2
assert [-2, - 2] == s.asteroidCollision([-2, -2, 1, -1]), 100000
assert [-2, -2] == s.asteroidCollision([1, 1, -2, -2]), -200
assert [10] == s.asteroidCollision([10, 2, -5]), -10
assert [-2, -2] == s.asteroidCollision([-2, 1, 1, -2]), -100
assert [-2, -1, 1, 2] == s.asteroidCollision([-2, -1, 1, 2]), -1
assert [5, 10] == s.asteroidCollision([5, 10, -5]), 1

print("tests passed")
