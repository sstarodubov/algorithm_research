class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return ""
        if len(s) == 1:
            return s[0]
        self.bound = [0, 0]

        def single_letter(idx: int):
            if idx == 0 or idx == len(s) - 1:
                return
            lp, rp = idx - 1, idx + 1
            while lp >= 0 and rp < len(s):
                if s[lp] != s[rp]:
                    return
                diff = self.bound[1] - self.bound[0]
                cur_diff = rp - lp
                if cur_diff > diff:
                    self.bound[0] = lp
                    self.bound[1] = rp
                lp -= 1
                rp += 1

        def double_letter(idx: int):
            if idx == 0:
                return
            lp, rp = idx - 1, idx
            while lp >= 0 and rp < len(s):
                if s[lp] != s[rp]:
                    return
                diff = self.bound[1] - self.bound[0]
                cur_diff = rp - lp
                if cur_diff > diff:
                    self.bound[0] = lp
                    self.bound[1] = rp
                lp -= 1
                rp += 1

        for i in range(len(s)):
            single_letter(i)
            double_letter(i)

        ans = s[self.bound[0]:self.bound[1] + 1]
        return ans


assert "bb" == Solution().longestPalindrome("cbbd")
assert "bab" == Solution().longestPalindrome("babad")
