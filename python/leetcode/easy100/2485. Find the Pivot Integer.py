class Solution:
    def pivotInteger(self, n: int) -> int:
       l, r = 1, n
       ls, rs = 1, n
       while l < r:
            if ls < rs:
               l+=1
               ls += l
            elif ls == rs:
                l+= 1
                r -= 1
                ls += l
                rs += r
            else:
               r -= 1
               rs += r
       if ls == rs:
           return l
       return -1


print(Solution().pivotInteger(8))

