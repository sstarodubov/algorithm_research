class Solution:
    def maxPower(self, s: str) -> int:
        power = 1
        prev = 0
        for i in range(1, len(s)):
            if s[prev] == s[i]:
                if i == len(s) - 1:
                    return max(power, i - prev + 1)
                else: continue
            else:
                power = max(i - prev, power)
                prev = i

        return power


assert 2 == Solution().maxPower("cc")
assert 2 == Solution().maxPower("leetcode")
