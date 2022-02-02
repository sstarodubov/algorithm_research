class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        i1 = 0
        while num1:
            last = num1[0]
            i1 = i1 * 10 + int(last)
            num1 = num1[1:]
        i2 = 0
        while num2:
            last = num2[0]
            i2 = i2 * 10 + int(last)
            num2 = num2[1:]
        return str(i2 + i1)



Solution().addStrings("123", "11")
