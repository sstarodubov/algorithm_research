import time


def current_milli_time():
    return round(time.time() * 1000)

class Solution:

    def longestPalindrome(self, s: str) -> str:
        def is_pol(st) -> bool:
            start, end = 0, len(st) - 1
            while start <= end:
                if st[start] != st[end]:
                    return False
                start += 1
                end -= 1
            return True

        if len(s) == 1:
            return s
        memo = set()

        def dfs(cur_str, memo):
            if cur_str in memo:
                return cur_str
            if len(cur_str) == 1:
                return cur_str
            if is_pol(cur_str):
                return cur_str

            left = dfs(cur_str[: -1], memo)
            right = dfs(cur_str[1:], memo)
            memo.add(left)
            memo.add(right)
            if len(left) > len(right):
                return left
            return right

        ans = dfs(s, memo)
        return ans

start = current_milli_time()
assert Solution().longestPalindrome("abbcccbbbcaaccbababcbcabca") == "cbababc"
print(current_milli_time() - start)
assert Solution().longestPalindrome("babad") == "aba"
assert Solution().longestPalindrome("ac") == "c"
assert Solution().longestPalindrome("a") == "a"
assert Solution().longestPalindrome("cbbd") == "bb"
print("tests passed")
