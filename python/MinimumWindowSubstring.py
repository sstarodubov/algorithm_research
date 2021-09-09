from collections import Counter


class Solution:

    def minWindow(self, s: str, t: str) -> str:
        def exist(st, l, r, subs):
            c = Counter(subs)
            for i in range(l, r + 1):
                if r >= len(st):
                    return False
                if st[i] in c:
                    c[st[i]] -= 1
            for k in c:
                if c[k] > 0:
                    return False
            return True

        if len(s) == len(t):
            if exist(s, 0, len(s) - 1, t):
                return s
            else:
                return ""
        left = 0
        right = len(t) - 1
        result = ""
        while left < len(s) - len(t) and right < len(s):
            flag = False
            while right < len(s):
                if exist(s, left, right, t):
                    flag = True
                    break
                else:
                    right += 1
            if not flag:
                return result
            while left < len(s):
                if not exist(s, left + 1, right, t):
                    break
                else:
                    left += 1
            tmp = s[left:right + 1]
            if result:
                if len(tmp) < len(result):
                    result = tmp
            else:
                result = tmp
            left += 1
            right += 1
        return result


s = Solution()

assert s.minWindow("abc", "a") == "a", 123123
assert s.minWindow("ab", "A") == "", -100
assert s.minWindow(s="a", t="a") == "a", 0
assert s.minWindow(s="a", t="aa") == "", -1
assert s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd") == "abbbbbcdd", 100
assert s.minWindow("a", "b") == "", 0
assert s.minWindow("abc", "ac") == "abc", 1
assert s.minWindow(s="ADOBECODEBANC", t="ABC") == "BANC", 1

print("tests passed")
