class Solution:

    # time O(n * m), space O(n*m)
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[0 for j in range(len(text2) + 1)] for i in range(len(text1) + 1)]

        for i in range(len(text1) - 1, - 1, -1):
            for j in range(len(text2) - 1, - 1, -1):
                if text1[i] == text2[j]:
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                else:
                    dp[i][j] = max(dp[i][j + 1], dp[i + 1][j])

        return dp[0][0]


assert Solution().longestCommonSubsequence(text1="abc", text2="def") == 0
assert Solution().longestCommonSubsequence(text1="abc", text2="abc") == 3
assert Solution().longestCommonSubsequence(text1="abcde", text2="ace") == 3
