"""
You are given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

"""


class Solution:

    # CPU O(n) and RAM O(1)
    def countSegments(self, s: str) -> int:
        if s == "": return 0
        ans = 0
        reading = False
        for i in range(0, len(s)):
            if s[i] != " " and not reading:
                reading = True
            elif s[i] == " " and reading:
                reading = False
                ans += 1
        return ans + 1 if reading else ans


s = Solution()

assert 5 == s.countSegments("Hello, my name is John"), "1"
assert 1 == s.countSegments("Hello"), "2"
assert 4 == s.countSegments("love live! mu'sic forever"), "3"
assert 0 == s.countSegments("")

print("tests passed")
