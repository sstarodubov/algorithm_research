class Solution:
    def countSegments(self, s: str) -> int:
        if not s: return 0
        flag = s[0].isalpha()
        ans = 1 if flag else 0

        for i in s:
            if not flag and i.isspace():
                continue
            elif flag and i.isspace():
                flag = False
            elif not flag and not i.isspace():
                ans += 1
                flag = True
            elif flag and not not i.isspace():
                continue
        return ans


assert 5 == Solution().countSegments("Hello, my name is John")
assert  1 == Solution().countSegments("Hello")