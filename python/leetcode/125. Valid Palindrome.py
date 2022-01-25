class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while l < r:
            while l < len(s) and not (s[l].isalpha() or s[l].isdigit()):
                l += 1
            while r >= 0 and not (s[r].isalpha() or s[r].isdigit()):
                r -= 1

            if l >= r:
                return True

            if s[l].lower() == s[r].lower():
                r -= 1
                l += 1
            else:
                return False
        return True


assert Solution().isPalindrome("A man, a plan, a canal: Panama")
assert not Solution().isPalindrome("0P")
assert not Solution().isPalindrome("race a car")
assert Solution().isPalindrome(" ")
