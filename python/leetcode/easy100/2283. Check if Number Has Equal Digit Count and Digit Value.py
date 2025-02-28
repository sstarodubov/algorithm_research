class Solution:
    def digitCount(self, num: str) -> bool:
        m = {}
        for n in num:
            cur = m.get(int(n), 0)
            m[int(n)] = cur + 1
        for i in range(len(num)):
            act = m.get(i, 0)
            if int(num[i]) != act:
                return False

        return True

print(Solution().digitCount("1210"))