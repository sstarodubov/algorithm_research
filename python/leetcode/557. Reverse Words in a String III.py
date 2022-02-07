class Solution:
    def reverseWords(self, s: str) -> str:
        arr = s.split(" ")
        ans = []
        for a in arr:
            if a:
                ans.append(a[::-1])
        return " ".join(ans)


assert Solution().reverseWords("Let's take LeetCode contest") == "s'teL ekat edoCteeL tsetnoc"
