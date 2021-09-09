from collections import Counter


class Solution:

    def minWindow(self, s: str, t: str) -> str:
        window = [""] * len(t)
        c = Counter(t)
        origin = Counter(t)
        begin = 0
        while len(window) <= len(s):
            if begin + len(window) > len(s):
                begin = 0
                window.append("")
            if len(window) > len(s):
                return ""
            for i in range(len(window)):
                window[i] = s[begin + i]
            begin += 1
            for w in window:
                if w in c:
                    c[w] -= 1
            flag = False
            for k in c:
                if c[k] > 0:
                    flag = True
                c[k] = origin[k]
            if flag:
                flag = False
            else:
                return "".join(window)
        return ""


s = Solution()

assert s.minWindow("abc", "ac") == "abc", 1
assert s.minWindow("a", "b") == "", 0
assert s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd") == "abbbbbcdd", 100
assert s.minWindow(s="ADOBECODEBANC", t="ABC") == "BANC", 1
assert s.minWindow(s="a", t="a") == "a", 0
assert s.minWindow(s="a", t="aa") == "", -1

print("tests passed")
