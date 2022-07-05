class Solution:

    #time O(2^n)
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        self.ans = 0

        def dfs(t, k, depth=0):
            self.ans = max(self.ans, depth)

            if t == "" or k == "":
                return

            for i in range(len(t)):
                for j in range(len(k)):
                    if k[j] == t[i]:
                        dfs(t[i + 1:], k[j + 1:], depth + 1)

        if len(text1) > len(text2):
            t = text1
            k = text2
        else:
            t = text2
            k = text1

        dfs(t, k)

        return self.ans


assert Solution().longestCommonSubsequence(text1="abc", text2="def") == 0
assert Solution().longestCommonSubsequence(text1="abc", text2="abc") == 3
assert Solution().longestCommonSubsequence(text1="abcde", text2="ace") == 3
