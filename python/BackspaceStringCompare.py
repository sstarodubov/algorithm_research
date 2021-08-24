"""
Given two strings s and t, return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

"""


class Solution:

    # cpu O(n) and ram O(1)
    def backspaceCompare(self, s: str, t: str) -> bool:
        sptr = len(s) - 1
        tptr = len(t) - 1
        scounter = 0
        tcounter = 0

        while True:
            while sptr >= 0 and s[sptr] == "#":
                scounter += 1
                sptr -= 1
                while scounter > 0 and s[sptr] != "#":
                    sptr -= 1
                    scounter -= 1
            while tptr >= 0 and t[tptr] == "#":
                tcounter += 1
                tptr -= 1
                while tcounter > 0 and t[tptr] != "#":
                    tptr -= 1
                    tcounter -= 1

            if tptr < 0 and sptr < 0:
                return True
            if tptr < 0:
                return False
            if sptr < 0:
                return False
            if t[tptr] == s[sptr]:
                tptr -= 1
                sptr -= 1
            else:
                return False


s = Solution()

assert s.backspaceCompare(s="ab##", t="c#d#"), 2
assert s.backspaceCompare(s="a##c", t="#a#c"), 3
assert s.backspaceCompare(s="ab#c", t="ad#c"), 1
assert not s.backspaceCompare(s="a#c", t="b"), 4

print("test passed")
