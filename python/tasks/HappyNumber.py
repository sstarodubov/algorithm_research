class Solution:

    def isHappy(self, n: int) -> bool:
        m = {}
        while True:
            cur_sum = 0
            cur_num = n

            while cur_num != 0:
                rest = cur_num % 10
                cur_num = (cur_num - rest) // 10
                cur_sum += rest ** 2

            if cur_sum == 1:
                return True
            if m.get(cur_sum):
                return False

            m[cur_sum] = True
            n = cur_sum


s = Solution()

assert s.isHappy(1111111), -1
assert s.isHappy(19), 1
assert not s.isHappy(121), 0
assert not s.isHappy(2), 2

print("tests passed")
