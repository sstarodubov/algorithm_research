class Solution:

    def isHappy(self, n: int) -> bool:
        def helper(num: int) -> int:
            ans = 0
            while num:
                last = num % 10
                ans += last ** 2
                num = num // 10

            return ans

        visit = set()
        while n not in visit:
            if n == 1:
                return True
            visit.add(n)
            n = helper(n)
        return False


assert not Solution().isHappy(2)
assert Solution().isHappy(19)
