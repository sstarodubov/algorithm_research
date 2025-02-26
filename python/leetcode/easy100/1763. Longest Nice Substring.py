class Solution:

    def isNice(self, s:str, hm):
       hm.clear()
       for ch in s:
          hm.add(ch)

       for ch in s:
           if ch.islower() and ch.upper() not in hm:
               return False
           if ch.isupper() and ch.lower() not in hm:
               return False
       return True

    def longestNiceSubstring(self, s: str) -> str:
        hm = set()
        ret = ""
        for i in range(len(s)):
            for j in range(i, len(s) + 1):
                ss = s[i:j]
                if len(ss) > len(ret) and self.isNice(ss, hm):
                    ret = ss
        return ret

print(Solution().longestNiceSubstring("bB"))