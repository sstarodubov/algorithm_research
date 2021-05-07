class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        alpha = {
            1: "A",
            2: "B",
            3: "C",
            4: "D",
            5: "E",
            6: "F",
            7: "G",
            8: "H",
            9: "I",
            10: "J",
            11: "K",
            12: "L",
            13: "M",
            14: "N",
            15: "O",
            16: "P",
            17: "Q",
            18: "R",
            19: "S",
            20: "T",
            21: "U",
            22: "V",
            23: "W",
            24: "X",
            25: "Y",
            26: "Z"
        }
        cur = columnNumber
        ans = ""
        while cur > 26:
            r = cur % 26
            if r != 0:
                ans = alpha[r] + ans
                tmp = cur - r
                cur = tmp // 26
            else:
                ans = "Z" + ans
                cur = (cur // 26) - 1

        ans = alpha[cur] + ans
        return ans


s = Solution()

assert "AZ" == s.convertToTitle(52), "AZ"
assert "AB" == s.convertToTitle(28), "AB"
assert "FXSHRXW" == s.convertToTitle(2147483647)

print("tests passed")
