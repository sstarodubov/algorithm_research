class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jd = set()
        for jewel in jewels:
            jd.add(jewel)

        ans = 0
        for stone in stones:
            if stone in jd:
                ans += 1
        return ans


assert Solution().numJewelsInStones(jewels="aA", stones="aAAbbbb")
